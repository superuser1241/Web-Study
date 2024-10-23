package mvc.ajax.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.google.gson.Gson;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mvc.ajax.dto.CustomerDTO;
import mvc.ajax.service.CustomerService;
import mvc.ajax.service.CustomerServiceImpl;


public class CustomerController implements RestController {
   private CustomerService customerService = new CustomerServiceImpl();
   
   public void test(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("axios test입니다....");
		

		PrintWriter out = response.getWriter();
		 out.print("22222OK.");
		
		
	}
   
	/**
	 * 아디중복체크
	 *  : 중복입니다, 사용가능합니다  String 응답
	 * */
	public void idCheck(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		boolean idCheck = customerService.idCheck(id);
		
		PrintWriter out = response.getWriter();
		if(idCheck) {
			out.println("중복입니다");
		}else {
			out.println("사용 가능합니다");
		}
	}
	
	
	
	/**
	 * 등록하기
	 *  : 서비스 리턴한 int형 그대로 응답
	 * */
	public void insert(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String tel = request.getParameter("tel");
		String addr = request.getParameter("addr");
		
		CustomerDTO customer = new CustomerDTO(id,name,age,tel,addr);
		int result = customerService.insert(customer);
		
		PrintWriter out = response.getWriter();
		out.println(result);
	}
	
	/**
	 * 전체검색
	 *  : List를 json으로 변환해서 응답
	 * */
	public void selectAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<CustomerDTO> customer = customerService.selectAll();
		
		Gson gson = new Gson();
		String jsonArr = gson.toJson(customer);
		
		PrintWriter out = response.getWriter();
		out.println(jsonArr);
	}
	
	/**
	 * 수정하기
	 *  : 수정된 결과 int형 응답
	 * */
	public void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String tel = request.getParameter("tel");
		String addr = request.getParameter("addr");
		
		CustomerDTO customer = new CustomerDTO(id,name,age,tel,addr);
		int result = customerService.update(customer);
		
		PrintWriter out = response.getWriter();
		out.println(result);
		
	}
	
	/**
	 * 삭제하기 
	 *  : 삭제된 결과 int형 응답
	 * */
	public void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		int result = customerService.delete(id);
		
		PrintWriter out = response.getWriter();
		out.println(result);
	}

}











