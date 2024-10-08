package ex1008.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

import dto.Member;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AjaxTestServlet
 */
@WebServlet(urlPatterns = "/ajax",loadOnStartup = 1)
public class AjaxJsonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//요청된 정보가 어떤 메소드를 실행해야하는지 체크
		String key = request.getParameter("key");
		System.out.println("key = " + key);
		if(key.equals("text")) {
			this.text(request, response);
		}else if(key.equals("json")) {
			this.json(request, response);
		}else if(key.equals("dto")) {
			this.dto(request, response);
		}else if(key.equals("list")) {
			this.list(request, response);
		}else if(key.equals("map")) {
			this.map(request, response);
		}else {
		    this.property(request, response);	
		}
	}
	
	/**
	 * text 결과
	 * */
    public void text(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//service ~~~~
    	
    	//응답
    	PrintWriter out = response.getWriter();
    	out.println("Welecome to ~");
    	
	}

	/**
	 * json결과
	 * */
   public void json(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//service -> dao 
	   List<String> menus = Arrays.asList("짜장면","짬뽕","짬짜면","볶음밥","쫄면");
	   
	   //응답할 menus를 JSON 객체로 변환해서 응답
	   Gson gson = new Gson();
	   String jsonArr = gson.toJson(menus);
	   System.out.println(jsonArr);
	   
	   //응답
	   PrintWriter out = response.getWriter();
	   out.println(jsonArr);
	}

	/**
	 * DTO 결과
	 * */
   public void dto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//3개 
	  Member member = new Member("Jun","영준",25,"서울");
	 
	  Gson gson = new Gson();
	  String jsonArr = gson.toJson(member);
	  
	  PrintWriter out = response.getWriter();
	  out.println(jsonArr);	  
	}
	
	/**
	 * List결과
	 * */
   public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  List<Member> list = new ArrayList<Member>();
	  list.add(new Member("Jun","영준",25,"서울"));
	  list.add(new Member("kim","민재",28,"인천"));
	  list.add(new Member("lee","강인",21,"부산"));
	  list.add(new Member("aaa","bb",25,"경기"));
	  list.add(new Member("No","yes",24,"포항"));
	  
	  Gson gson = new Gson();
	  String jsonArr= gson.toJson(list);
	  
	  PrintWriter out = response.getWriter();
	  out.println(jsonArr);
	}
	
	/**
	 * Map결과
	 * */
   public void map(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  Map<String, Object> map = new HashMap<String, Object>();
	  map.put("messege", "Ajax재미있다");
	  map.put("pageNo", 20);
	  map.put("dto", new Member("Jun","영준",25,"서울"));
	  
	  List<Member> list = new ArrayList<Member>();
	  list.add(new Member("Jun","영준",25,"서울"));
	  list.add(new Member("kim","민재",28,"인천"));
	  list.add(new Member("lee","강인",21,"부산"));
	  map.put("memberList", list);
	  
	  Gson gson = new Gson();
	  String jsonArr= gson.toJson(map);
	  
	  PrintWriter out = response.getWriter();
	  out.println(jsonArr);
	}
	
	/**
	 * property 결과
	 * */
   public void property(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}







