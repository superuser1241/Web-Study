package web.mvc.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class OrderController implements Controller {
	public ModelAndView selectAll(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("OrderController selectAll");
		
		return new ModelAndView("order/selectAll.jsp");
	}
	
	public ModelAndView insert(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("OrderController insert");
		
		return new ModelAndView("order/insert.jsp",true);
	}
}
