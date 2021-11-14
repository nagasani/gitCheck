package com.example2.demo2.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example2.demo2.vo.HelloWorld;

@RestController
public class HelloWorldController {
	
	@GetMapping
	public HelloWorld invoke() {
		return new HelloWorld();
	}

}
