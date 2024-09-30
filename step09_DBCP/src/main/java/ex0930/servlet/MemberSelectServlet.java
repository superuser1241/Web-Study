package ex0930.servlet;

import java.io.IOException;
import java.util.List;

import ex0930.dao.MemberDAOImpl;
import ex0930.dto.MemberDTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/selectAll")
public class MemberSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    MemberDAOImpl dao = new MemberDAOImpl();

    public MemberSelectServlet() {
    	
    }

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			List<MemberDTO> list = dao.selectAll();
			request.setAttribute("list", list);
	    	
	    	request.getRequestDispatcher("memberSelect.jsp").forward(request, response);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
}
