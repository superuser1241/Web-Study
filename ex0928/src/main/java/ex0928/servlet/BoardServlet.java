package ex0928.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import ex0928.dto.BoardDTO;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class BoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public BoardServlet() {

    }


//	public void init(ServletConfig config) throws ServletException {
//		
//		ServletContext application = getServletContext();
//		 List<BoardDTO> boardList = new ArrayList<>();
//	     application.setAttribute("boardList", boardList);
//	}


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//int no = Integer.parseInt(request.getParameter("no"));
		
		ServletContext application = getServletContext();
		List<BoardDTO> boardList = (List<BoardDTO>) application.getAttribute("boardList");
		
		int no = boardList.size() + 1;
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		
		BoardDTO board = new BoardDTO(no, subject, content);
		boardList.add(board);
		application.setAttribute("boardList", boardList);
		
		response.setContentType("text/html; charset=UTF-8");//한글 꺠짐;
		
		PrintWriter out = response.getWriter();
		out.write("<script>top.location.href='index.jsp';</script>");
	}

}
