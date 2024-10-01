package web.mvc.controller;

import java.io.IOException;
import java.util.Arrays;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * 	상품관리 Controller
 * */
public class GoodsController implements Controller {
	
	
	/**
	 * 	상품 List
	 * */
	public ModelAndView list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("GoodsController list...");
		
		request.setAttribute("goodsList", Arrays.asList("새우깡","감자깡","콘칩"));
		
		return new ModelAndView("goods/list.jsp",true);
	}
	
	/**
	 * 	상품 등록
	 * */
	public ModelAndView insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("GoodsController insert....");
		
		//서비스 호출한 후
		
		return new ModelAndView("goods/registerOk.jsp",true);
	}
}
