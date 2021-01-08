package com.example.demo.board.mapper;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.board.dto.BoardDto;

import lombok.extern.log4j.Log4j2;

@Log4j2
@SpringBootTest
public class MapperTest {
	
	@Autowired
	private BoardMapper boardMapper;
	
	@Test
	public void testSelectAll() {

			List<BoardDto> boardList = boardMapper.getList();
			if(!boardList.isEmpty()) {	//리스트가 비었나?
				for(BoardDto board:boardList) {	//foreach문
					System.out.println("==============================");
					//System.out.println(board.getTitle());
					System.out.println("==============================");
					
					
					
				}
			}
		}
	@Test
	public void testInsert() {
		
		BoardDto board = new BoardDto();
		//board.setTitle("spring insert");
		//board.setContents("spring contents");
		//board.setUpdateId("spring writer");
		
		boardMapper.insert(board);
		
		log.info(board);
	}
	
	@Test
	public void testread() {
		
		BoardDto board = boardMapper.read(2);
		
		log.info("over here:"+ board);
	}
	
	@Test
	public void testDelete() {
		
		log.info("DELETE COUNT: " +boardMapper.delete(2));
		
	}
	
	@Test
	public void testUpdate() {
		
		BoardDto board = new BoardDto();
		
		//board.setBoardIdx(3);
		//board.setTitle("springUpdateTitle");
		//board.setContents("springUpdateContents");
		//board.setUpdateId("springUpdateId");
		
		int count = boardMapper.update(board);
		
		log.info("UPDATE COUNT: "+ count);
		
		
	}
	

}
