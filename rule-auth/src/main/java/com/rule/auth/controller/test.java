package com.rule.auth.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class test {



	@GetMapping("/")
	public String home() throws Exception{


		return "/index";
	}
}
