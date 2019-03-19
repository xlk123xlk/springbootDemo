package com.xlk.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("docker")
public class HelloController {

	@RequestMapping(value = "say")
    public String sayHello(){
        return "Hello boy.Welcome here!";
    }
}
