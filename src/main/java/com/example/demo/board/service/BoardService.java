package com.example.demo.board.service;

import java.util.HashMap;
import java.util.List;

import com.example.demo.board.dto.BoardDto;


public interface BoardService {

	public List<BoardDto> getList() throws Exception;
	
	public int insert(BoardDto board);
	
	public BoardDto read(int boardIdx);
	
	public boolean delete(int boardIdx);
	
	public boolean update(BoardDto board);
	
	public HashMap<String, Object> read2();
	
}
