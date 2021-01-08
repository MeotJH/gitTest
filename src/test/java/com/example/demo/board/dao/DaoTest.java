package com.example.demo.board.dao;

import java.util.HashMap;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.board.dto.BoardDto;

@SpringBootTest
public class DaoTest {

	@Autowired
	BoardDao boardDao;
	
	@Test
	public void readTest() {
		
		HashMap<String, Object> boardDto = boardDao.read();
		System.out.println(boardDto);
	}
}
