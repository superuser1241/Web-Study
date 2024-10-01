package web.mvc.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SelectController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//검색기능 -> service 호출
		System.out.println("SelectController call...");
		
		request.setAttribute("message", "검생된 결과 정보입니다.");
		
		return new ModelAndView("selectResult.jsp"); //${message)
	}

}
