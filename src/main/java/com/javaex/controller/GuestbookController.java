package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.service.GuestbookService;
import com.javaex.vo.GuestVo;

@Controller
public class GuestbookController {
	
	//필드
	@Autowired
	private GuestbookService guestbookService;
	//생성자
	//메소드 - g/s
	//메소드 - 일반
	
	//addList
	@RequestMapping(value="/guest/addlist",  method = { RequestMethod.GET, RequestMethod.POST })
	public String addList(Model model) {
		System.out.println("GuestbookController.addList()");
		
		List<GuestVo> guestList = guestbookService.exeList();
		
		model.addAttribute("guestList", guestList);
		return "addList";
	}
	
	//등록
	@RequestMapping(value = "/guest/insert", method = { RequestMethod.GET, RequestMethod.POST })
	public String insert(@ModelAttribute GuestVo GuestVo) {
		
		//서비스를 메모리에 올리고 서비스의 메소드 사용 
		guestbookService.exeInsert(GuestVo);
		
		return "redirect:/guest/addlist";
	}
	
	//삭제폼
	@RequestMapping(value="/guest/deleteform", method = { RequestMethod.GET, RequestMethod.POST})
	public String deleteForm() {
		System.out.println("GuestbookController.deleteForm()");
		
		return "deleteForm";
	}
	
	//삭제
	@RequestMapping(value="/guest/delete", method = { RequestMethod.GET, RequestMethod.POST})
	public String delete(@RequestParam(value="no") int no, @RequestParam(value="password") String pw) {
		System.out.println("GuestbookController.delete()");
		
		guestbookService.exeDelete(no, pw);
		return "redirect:/guest/addlist";
	}
	
}
