package com.example.demo.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.board.service.BoardService;


import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
@RequestMapping("/board/*")
@AllArgsConstructor
public class BoardController{
	
	private BoardService service;
	
	@GetMapping("/list")
	public void list(Model model) throws Exception {
		
		log.info("list갔냐");
		
		
		model.addAttribute("list", service.getList());
	
		
	}
	
	@GetMapping ("/hello")
	public String hello() {
		return "hello"; 
		
	}

	

}
