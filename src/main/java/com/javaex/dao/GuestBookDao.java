package com.javaex.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.GuestVo;

@Repository
public class GuestBookDao {
	
	@Autowired
	private SqlSession sqlSession;

	// 삭제
	public int guestDelete(GuestVo guestVo) {
		System.out.println("GuestbookDao.guestDelete()");
		
		int count = sqlSession.delete("guestbook.delete", guestVo);
		
		return count;
	}

	

	// 전체 가져오기
	public List<GuestVo> guestSelect() {
		System.out.println("GuestbookDao.guestSelect()");
		
		List<GuestVo> guestList = sqlSession.selectList("guestbook.select");
		System.out.println(guestList);
		
		return guestList;
	}
	

	// 등록
	public int guestInsert(GuestVo guestVo) {
		System.out.println("GuestbookDao.guestInsert()");
		
		int count = sqlSession.insert("guestbook.insert", guestVo);
		System.out.println(count);
		
		return 0;
	}
}
