package ex0928.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
    public LoginServlet() {
    	
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String dbId = "미로";
		String dbPwd = "11"; 
		
		String id = request.getParameter("userId");
		String pwd = request.getParameter("userPwd");
		
		PrintWriter out = response.getWriter();
		if(dbId.equals(id) && dbPwd.equals(pwd)) {
			HttpSession session = request.getSession();
			session.setAttribute("userId", id);
			//session.setAttribute("time", session.getCreationTime()); //이건 타입변환 불가능함
			session.setAttribute("time", new java.util.Date());
			
			out.write("<script>top.location.href='index.jsp';</script>");
		}
		else {
			out.write("<script>alert('로그인에 실패하셨습니다 다시 로그인해주세요'); top.location.href='index.jsp';</script>");
		}
	}

}
