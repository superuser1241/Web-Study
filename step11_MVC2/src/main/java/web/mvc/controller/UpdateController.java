package web.mvc.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UpdateController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//검색기능 -> service 호출
		System.out.println("UpdateController call...");
		
		request.setAttribute("message", "수정 결과 정보입니다.");
		
		return new ModelAndView("updateResult.jsp"); //${message)
	}

}
