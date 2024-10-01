package web.mvc.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class InsertController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//등록 기능 --> 전송된 데이터 받기, DTO 만들고 service 호출
		//--> 결과를 받음
		
		System.out.println("InsertController call..");
		ModelAndView mv = new ModelAndView("index.jsp",true);
		
		return mv;
	}

}
