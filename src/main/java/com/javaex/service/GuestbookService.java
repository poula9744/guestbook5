package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.GuestBookDao;
import com.javaex.vo.GuestVo;

@Service
public class GuestbookService {

	//필드
	@Autowired
	private GuestBookDao guestbookDao;
	
	//생성자
	//메소드 - g/s
	//메소드 - 일반
	
	//등록
	public void exeInsert(GuestVo guestVo) {
		System.out.println("insert: 등록");
		
		guestbookDao.guestInsert(guestVo);
	}
	
	//삭제
	public void exeDelete(int no, String pw) {
		System.out.println("exeDeleteForm: 삭제폼");
		
		guestbookDao.guestDelete(no, pw);
	}
	
	//리스트
	public List<GuestVo> exeList() {
		System.out.println("exeList: 리스트");
	
		List<GuestVo> guestList = guestbookDao.guestSelect();;
		return guestList;
	}
	
}
