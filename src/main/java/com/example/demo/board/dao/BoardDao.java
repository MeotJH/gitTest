package com.example.demo.board.dao;

import java.util.HashMap;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.board.dto.BoardDto;

@Repository
public class BoardDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public HashMap<String, Object> read() {
		return sqlSession.selectOne("com.example.demo.board.dao.BoardDao.read");
	}
	
}
