package web.mvc.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DeleteController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//검색기능 -> service 호출
		System.out.println("DeleteController call...");
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index.jsp");
		mv.setRedirect(true);
		
		return mv;
	}

}
