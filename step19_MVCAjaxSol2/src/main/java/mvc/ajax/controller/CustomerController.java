package mvc.ajax.controller;

import java.io.IOException;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mvc.ajax.dto.CustomerDTO;
import mvc.ajax.service.CustomerService;
import mvc.ajax.service.CustomerServiceImpl;


public class CustomerController implements RestController {
   private CustomerService customerService = new CustomerServiceImpl();
   
  
	/**
	 * 아디중복체크
	 * */
	public Object idCheck(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		boolean result = customerService.idCheck(id);
	
		
		JsonObject obj = new JsonObject();
		
		if(result) obj.addProperty("info", "중복입니다.");
		else obj.addProperty("info","사용가능합니다.");
		
		return obj;
		
		
		/*String str="";
		if(result) str = "중복";
		else  str= "사용가능";
		return str;*/
	}
	
	
	
	/**
	 * 등록하기
	 * */
	public Object insert(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String tel = request.getParameter("tel");
		String addr = request.getParameter("addr");
		
		CustomerDTO dto = new CustomerDTO(id, name, Integer.parseInt(age), tel, addr);
		int result = customerService.insert(dto);
		
		return result;
	}
	
	/**
	 * 전체검색
	 * */
	public Object selectAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		List<CustomerDTO> list = customerService.selectAll();
		
		
		return list;
		 
	}
	
	/**
	 * 수정하기
	 * */
	public Object update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String tel = request.getParameter("tel");
		String addr = request.getParameter("addr");
		
		CustomerDTO dto = new CustomerDTO(id, name, Integer.parseInt(age), tel, addr);
		int result = customerService.update(dto);
		
		return result;
	}
	
	/**
	 * 삭제하기 
	 * */
	public Object delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
         String id =   request.getParameter("id");
         
        int result =  customerService.delete(id);
       
		return result;
	}

}











