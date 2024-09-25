package ex0923_Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
	/** 
	 * 	
	 * */
public class LoginServlet extends HttpServlet {
	String dbId = "mng2665";
	String dbPwd = "11";
		
		public LoginServlet() {
			System.out.println("LoginServlet 생성자....");
		}
		/**
		 * 	요청을 처리할 메소드 재정의
		 * */
		@Override
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			//전송된 데이터 받기
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			String name = request.getParameter("name");
			String age = request.getParameter("age");
			
			//name ="hobby"로 값이 여러개 넘어온다
			String hobby[] = request.getParameterValues("hobby");
			
			System.out.println("id = " + id);
			System.out.println("pwd = " + pwd);
			System.out.println("name = " + name);
			System.out.println("age = " + age);
			
			for(String h : hobby) {
				System.out.println(h);
			}
			
			//id와 비번이 일치하면 LoginOk.jsp , 아니면 폼으로 이동
			if(dbId.equals(id) && dbPwd.equals(pwd)) {
				
				//새로운 request, response를 생성해서 이동한다
//				name = URLEncoder.encode(name,"UTF-8");
//				response.sendRedirect("LoginOk.jsp?name="+name);
				
				//forward 방식으로 이동해보자
				RequestDispatcher rd = request.getRequestDispatcher("LoginOk.jsp");
				rd.forward(request, response);
				
			}else {
				response.setContentType("text/html;charset=UTF-8");
				
				//에러 메세지 출력
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('login fail : 정보 다시확인해')");
				//out.println("location.href='HobbyForm.html'");
				out.println("history.back()");
				out.println("</script>");
				
				//response.sendRedirect("HobbyForm.html");
			}
		}
		
}
