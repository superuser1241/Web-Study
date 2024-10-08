package ex1008.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/ajaxCheck", loadOnStartup = 1)
public class AjaxTestServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//전송된 데이터 받기
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		System.out.println("name :"+ name);
		System.out.println("id :"+ id);
		
		//서비스 -> dao -> 결과를 받아서
		//브라우저로 응답
		
		PrintWriter out = response.getWriter();
		out.println(name + "님 반갑습니다, Nice to meet you");
	}
	
}
