package com.example.demo.board.controller;


import java.util.HashMap;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.board.dao.BoardDao;
import com.example.demo.board.dto.BoardDto;
import com.example.demo.board.service.BoardService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RequestMapping("/boardapi/")
@RestController
@Log4j2
@AllArgsConstructor
public class BoardRestController {
	
	private BoardService boardService;

	//list
	@GetMapping(value = "/list", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<List<BoardDto>> getList() throws Exception{
		
		return new ResponseEntity<>(boardService.getList(), HttpStatus.OK);
		
	}
	
	//insert
	@PostMapping(value = "/new", consumes = "application/json", produces = { MediaType.TEXT_PLAIN_VALUE } )
	public ResponseEntity<String> create(@RequestBody BoardDto dto){
		
		log.info("BoardDto: " + dto);
		
		int insertCount = boardService.insert(dto);
		
		log.info("Reply Insert Count : "+ insertCount);
		
		return insertCount == 1
		? new ResponseEntity<>("success", HttpStatus.OK)
		: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	//read one
	@GetMapping(value = "/{boardIdx}",
				produces = { MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<BoardDto> get(@PathVariable("boardIdx") int boardIdx){
		
		log.info("read:"+ boardIdx);
		
		return new ResponseEntity<>(boardService.read(boardIdx), HttpStatus.OK);
	}
	
	//delete
	@DeleteMapping( value="/{boardIdx}", produces = { MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> remove(@PathVariable("boardIdx") int boardIdx){
		
		return boardService.delete(boardIdx) == true
				? new ResponseEntity<>("success", HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	//update
	@RequestMapping(method = {RequestMethod.PUT, RequestMethod.PATCH},
			value = "/{boardIdx}",
			consumes = "application/json",
			produces= {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> modify( @RequestBody BoardDto dto, @PathVariable("boardIdx") int boardIdx ){
		
		//dto.setBoardIdx(boardIdx);
		
		log.info("boardIdx : "+ boardIdx);
		log.info("modify: "+ dto);
		
		return boardService.update(dto) == true
				? new ResponseEntity<>("success", HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	//read one
	@GetMapping(value = "/test", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<HashMap<String, Object>> getOne() throws Exception{
		
		return new ResponseEntity<>(boardService.read2(), HttpStatus.OK);
		
	}
	
}
