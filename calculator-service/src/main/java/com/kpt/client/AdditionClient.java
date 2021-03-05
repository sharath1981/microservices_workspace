package com.kpt.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("proxy-server-api-gateway/addition-service") // via zuul proxy server api gateway
//@FeignClient("ADDITION-SERVICE") // direct call
//@RibbonClient("ADDITION-SERVICE") //client side load balancing by ribbon
public interface AdditionClient {
	@GetMapping("addition/{x}/{y}")
	Integer addition(@PathVariable Integer x, @PathVariable Integer y);
}
