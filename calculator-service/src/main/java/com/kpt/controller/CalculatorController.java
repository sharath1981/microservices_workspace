package com.kpt.controller;

import java.util.stream.IntStream;

import com.kpt.client.AdditionClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RequestMapping("calculator")
@RestController
public class CalculatorController {

	@Autowired
	private AdditionClient additionClient;
	
	@Value("${custom.prop}")
	private String customProp;
	
	@HystrixCommand(fallbackMethod = "addition_short_circuit")
	@GetMapping("add/{x}/{y}")
	public Integer addition(@PathVariable Integer x, @PathVariable Integer y) {
		return additionClient.addition(x, y);
	}
	
	@HystrixCommand(fallbackMethod = "multiply_short_circuit")
	@GetMapping("multiply/{x}/{y}")
	public Integer multiply(@PathVariable Integer x, @PathVariable Integer y) {
		return IntStream.range(0, x)
		                .boxed()
		                .mapToInt(e->additionClient.addition(0, y))
		                .sum();
	}
	
	public Integer addition_short_circuit(Integer x, Integer y) {
		return x+y;
	}
	
	public Integer multiply_short_circuit(Integer x, Integer y) {
		return x*y;
	}
	
	@GetMapping("name")
	public String getCustomProp() {
		return customProp;
	}


}
