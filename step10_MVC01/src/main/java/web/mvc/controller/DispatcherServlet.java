package web.mvc.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * 	모든 요청을 중앙집중적으로 관리해줄 진입점 Controller이다 =FrontController이다
 * */
@WebServlet(urlPatterns = "/front", loadOnStartup = 1)
public class DispatcherServlet extends HttpServlet {
	
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//전송된 key 받기
		String key = request.getParameter("key");
		System.out.println(key);
		
		Controller con =null;
		if(key.equals("insert")) {
			con= new InsertController();
			
		}else if(key.equals("select")) {
			con= new SelectController();
			
		}else if(key.equals("update")) {
			con= new UpdateController();
			
		}else if(key.equals("delete")) {
			con= new DeleteController();
			
		}
		
		ModelAndView mv =con.handleRequest(request, response);
		
		if(mv.isRedirect()) {
			response.sendRedirect(mv.getViewName());
		}else {
			request.getRequestDispatcher(mv.getViewName()).forward(request, response);
		}
	}
	
}
