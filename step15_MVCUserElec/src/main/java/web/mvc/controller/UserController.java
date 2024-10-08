package web.mvc.controller;

import java.sql.SQLException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import web.mvc.dto.UserDTO;
import web.mvc.exception.AuthenticationException;
import web.mvc.service.UserServiceImpl;

public class UserController implements Controller {
	UserServiceImpl service = new UserServiceImpl();
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String methodName = request.getParameter("methodName");
		ModelAndView mv = null;
		
		try {
			if(methodName.equals("login")) {
				mv = login(request, response);
			}else if(methodName.equals("logout")) {
				mv = logout(request, response);
			}
		}catch(Exception e) {
			e.printStackTrace();
			mv = new ModelAndView("error/error.jsp");
		}
		
		return mv;
	}
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws SQLException, AuthenticationException{
		String id = request.getParameter("userId");
		String pwd = request.getParameter("pwd");
		UserDTO user = service.loginCheck(new UserDTO(id, pwd));
		if (user != null) {
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", user);
			
			return new ModelAndView("index.jsp", true);
		} else {
			request.setAttribute("errorMsg", "아이디 또는 비밀번호가 잘못되었습니다.");
			return new ModelAndView("error/error.jsp");
		}
	}
	
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		if (session != null) {
			session.invalidate(); 
		}
		return new ModelAndView("index.jsp",true);
	}
}
