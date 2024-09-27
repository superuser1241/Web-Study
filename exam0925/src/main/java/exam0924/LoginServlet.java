package exam0924;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

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
			request.setAttribute("errMsg", name+"님 정보를 찾을 수 없습니다");
			
			request.getRequestDispatcher("error/error.jsp").forward(request, response);
		}
	}

}
