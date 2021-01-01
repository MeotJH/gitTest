package com.example.demo.board.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class apiController {
	
	@GetMapping("/api/hello")
	public String hello() {
		return "hello man";
	}

}
