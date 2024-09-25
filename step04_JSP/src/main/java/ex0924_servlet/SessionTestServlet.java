package ex0924_servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(urlPatterns = "/sessionServlet", loadOnStartup = 1)

public class SessionTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SessionTestServlet() {
        System.out.println("SessionTestServlet 생성자....");
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet 요청됨...");
		
		//session 정보를 조회해보자!!-> HttpSession 먼저 얻은 후에 조회
		HttpSession session= request.getSession();
		String name = (String)session.getAttribute("name");
		String id = (String)session.getAttribute("id");
		String hobby[] = (String[])session.getAttribute("hobby");
		
		System.out.println("name = "+name);
		System.out.println("id = "+id);
		System.out.println("hobby = "+hobby);
		
		//service를 호출하고 그 결과를 받아서 뷰 쪽으로 이동하고싶다!!
		List<String> menus = Arrays.asList("짬뽕","짜장","탕수육","튀김우동");
		//menu를 request scope에 저장한다
		request.setAttribute("menus", menus); //뷰에서 사용
		
		//ServletContext영역에 저장된 정보 조회하기
		ServletContext application = request.getServletContext();
		System.out.println("주소 : "+application.getAttribute("addr"));
		System.out.println("메세지 : "+application.getAttribute("message"));
		
		//뷰쪽으로 이동!!
		//response.sendRedirect("session/sessionOk.jsp");
		
		//request에 저장된 정보가 유지되기 위해서 forward 방식으로 이동
		RequestDispatcher rd = request.getRequestDispatcher("session/sessionOk.jsp");
		rd.forward(request, response);
	}

}
