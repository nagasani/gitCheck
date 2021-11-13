package com.second.sample.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/sample")
public class Controller {
	
	@GetMapping("/data")
	public String getData()
	{
		return "Hello Ram";
	}

}
