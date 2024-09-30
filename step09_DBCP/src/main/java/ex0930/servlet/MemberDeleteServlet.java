package ex0930.servlet;

import java.io.IOException;


import ex0930.dao.MemberDAOImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/delete")
public class MemberDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    MemberDAOImpl dao = new MemberDAOImpl();

    public MemberDeleteServlet() {
    	
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String id = request.getParameter("id");
			int re = dao.delete(id);
			
			if(re>0) {
				response.sendRedirect("selectAll");
			}else {
				request.setAttribute("errMsg", "삭제에 실패하였습니다");
				request.getRequestDispatcher("error.jsp").forward(request, response);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
