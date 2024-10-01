package web.mvc.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * 	게시판 관리를 위한 Controller
 * */
public class BoardController implements Controller {
	
	
	/**
	 * 	게시판 List
	 * */
	public ModelAndView list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("BoardController list....");
		
		//서비스호출하고 결과를 받는다
		
		request.setAttribute("message", "게시판 조회 완료!");
		
		return new ModelAndView("board/list.jsp");
	}
	
	/**
	 * 	상세보기
	 * */
	public ModelAndView read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("BoardController read....");
		
		//서비스 호출한 후....
		
		return new ModelAndView("board/read.jsp",true);
	}
}
