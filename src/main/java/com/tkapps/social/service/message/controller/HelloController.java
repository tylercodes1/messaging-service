package com.tkapps.social.service.message.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("hello")
public class HelloController {
    @ApiOperation(value = "Returns \"Hello, World\" to ensure CORS policies aren't blocked")
    @GetMapping("")
    public String hello() {
        System.out.println("This is hello");
        return "Hello, World";
    }

    @GetMapping("/error")
    public String error() throws Exception {
        if (true) throw new Exception("For understanding logging and Aspect4J only.");
        return "For understanding logging and Aspect4J only.";
    }
}
