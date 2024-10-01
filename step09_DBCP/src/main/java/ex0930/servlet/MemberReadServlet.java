package ex0930.servlet;

import java.io.IOException;

import ex0930.dao.MemberDAOImpl;
import ex0930.dto.MemberDTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/readServlet")
public class MemberReadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    MemberDAOImpl dao = new MemberDAOImpl();

    public MemberReadServlet() {
        
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String id = request.getParameter("id");
			MemberDTO member = dao.getSelectById(id);
			
			if(member==null) {
				request.setAttribute("errMsg", "회원정보를 읽어올 수 없습니다");
				request.getRequestDispatcher("error.jsp").forward(request, response);
			}
			else {
				request.setAttribute("member", member);
				request.getRequestDispatcher("read.jsp").forward(request, response);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
