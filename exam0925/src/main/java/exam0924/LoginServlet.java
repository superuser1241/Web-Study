package exam0924;

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
		String dbId = "윤성바오바오";
		String dbPwd = "11"; 
		
		String id = request.getParameter("userId");
		String pwd = request.getParameter("userPwd");
		String name = request.getParameter("userName");
		
		if(dbId.equals(id) && dbPwd.equals(pwd)) {
			HttpSession session = request.getSession();
			session.setAttribute("userId", id);
			session.setAttribute("userName", name);
			
			long time = session.getCreationTime();
			session.setAttribute("time", time);
			
			response.sendRedirect("LoginOk.jsp");
		}
		else {
			response.setContentType("text/html;charset=UTF-8");
			
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('로그인 정보가 틀립니다 다시 로그인해주세요')");
			out.println("history.back()");
			out.println("</script>");
		}
	}

}
