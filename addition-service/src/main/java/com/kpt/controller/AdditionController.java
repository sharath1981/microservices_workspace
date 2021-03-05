package com.kpt.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdditionController {

    private static final Logger log = LoggerFactory.getLogger(AdditionController.class);

    @Autowired
    private Environment environment;

    @GetMapping("addition/{x}/{y}")
    public Integer addition(@PathVariable Integer x, @PathVariable Integer y) {
        log.info("SERVED BY PORT => " + environment.getProperty("server.port"));
        return x + y;
    }

}
