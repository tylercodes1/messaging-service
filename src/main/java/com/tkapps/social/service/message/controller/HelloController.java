package com.tkapps.social.service.message.controller;

import com.tkapps.social.service.message.exceptions.TestControllerException;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/error/{error}")
    public String error(@PathVariable("error") boolean error) throws TestControllerException {
        if (error) throw new TestControllerException("For understanding logging and Aspect4J only.");
        return "No error thrown";
    }
}
