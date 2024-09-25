package ex0923_Servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
/**
 * 	Servlet 등록을 @annotation 방법으로 설정
 * */
@WebServlet(loadOnStartup = 1, urlPatterns = "/blood")



public class BloodServlet extends HttpServlet {
	String myName ="주영준";

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String blood = request.getParameter("blood");
		
		System.out.println(name);
		System.out.println(blood);
		
		if(myName.equals(name)) {
			RequestDispatcher rd = request.getRequestDispatcher(blood+".jsp");
			rd.forward(request, response);
		}
	}

	
	
}
