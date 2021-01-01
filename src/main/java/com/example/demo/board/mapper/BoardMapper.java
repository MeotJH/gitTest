package com.example.demo.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.board.dto.BoardDto;

@Mapper
public interface BoardMapper {
	
	public List<BoardDto> getList();
	
	public int insert(BoardDto board);
	
	public BoardDto read(int boardIdx);
	
	public int delete(int boardIdx);
	
	public int update(BoardDto board);
	

}
