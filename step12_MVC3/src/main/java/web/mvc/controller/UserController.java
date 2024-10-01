package web.mvc.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * 	회원관리 Controller
 * */
public class UserController implements Controller {
	
	
	/**
	 * 	로그인하기
	 * */
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("UserController login...");
		
		//로그인 기능 완료후..... 세션에 정보를 저장하자
		HttpSession session=request.getSession();
		session.setAttribute("sessionMessage", "로그인 성공!!");
		
		return new ModelAndView("user/login.jsp",true);
	}
	
	/**
	 * 	회원정보 수정
	 * */
	public ModelAndView update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("UserController update....");
		
		//회원정보 수정을 완료한 후 이동
		request.setAttribute("message","정보수정완료!");
		
		return new ModelAndView("user/update.jsp");
	}
}
