package ex0930.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import ex0930.dao.MemberDAOImpl;
import ex0930.dto.MemberDTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/insert")
public class MemberInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MemberDAOImpl dao = new MemberDAOImpl();
    
    public MemberInsertServlet() {
        
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			String name = request.getParameter("name");
			int age = Integer.parseInt(request.getParameter("age"));
			String phone = request.getParameter("phone");
			String addr = request.getParameter("addr");
			
			MemberDTO member = new MemberDTO(id,pwd,name,age,phone,addr);
			
			int re;
			if(dao.getSelectById(id)!=null) {
				request.setAttribute("errMsg", "아이디가 중복입니다.");
	            RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
	            dispatcher.forward(request, response);
				return;
				
			}else {
				re = dao.insert(member);
			}
			
			if(re==0) {
				request.setAttribute("errMsg", "회원정보 저장에 실패하였습니다");
				request.getRequestDispatcher("error.jsp").forward(request, response);
			}else {
				response.sendRedirect("index.jsp");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
