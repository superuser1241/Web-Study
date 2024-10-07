package web.mvc.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CartController implements Controller {
	public ModelAndView insert(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("CartController insert");
		
		return new ModelAndView("cart/insert.jsp");
	}
	
	public ModelAndView select(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("CartController select");
		
		return new ModelAndView("cart/select.jsp",true);
	}
}
