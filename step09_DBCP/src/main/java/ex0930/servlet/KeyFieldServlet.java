package ex0930.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import ex0930.dao.MemberDAOImpl;
import ex0930.dto.MemberDTO;

@WebServlet("/search")
public class KeyFieldServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    MemberDAOImpl dao = new MemberDAOImpl();

    public KeyFieldServlet() {
        
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String keyField = request.getParameter("keyField");
		    String keyWord = request.getParameter("keyWord");
		    
			List<MemberDTO> list = dao.findBykeyFieldWord(keyField, keyWord);
			request.setAttribute("list", list);
			
			request.getRequestDispatcher("memberSelect.jsp").forward(request, response);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
