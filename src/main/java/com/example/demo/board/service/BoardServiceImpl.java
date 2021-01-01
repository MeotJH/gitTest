package com.example.demo.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.board.dto.BoardDto;
import com.example.demo.board.mapper.BoardMapper;


@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardMapper boardMapper;
	
	@Override
	public List<BoardDto> getList() throws Exception{
		
		return boardMapper.getList();
		
	}
	
	@Override
	public int insert(BoardDto board) {
		
		return boardMapper.insert(board);
		
	};
	
	
	@Override
	public BoardDto read(int boardIdx) {
		
		return boardMapper.read(boardIdx);
		
	};
	
	
	@Override
	public boolean delete(int boardIdx) {
		
		return boardMapper.delete(boardIdx) == 1;
		
	};
	
	
	@Override
	public boolean update(BoardDto board) {
		
		return boardMapper.update(board) == 1;
	};
	

}
