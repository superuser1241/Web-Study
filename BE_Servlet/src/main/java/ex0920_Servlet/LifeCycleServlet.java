package ex0920_Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LifeCycleServlet extends HttpServlet {

	public LifeCycleServlet() {
		System.out.println("LifeCycleServlet 생성자.....");
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("LifeCycleServlet doGet 요청.....");
		//브라우저에 응답할 문서의 형태와 인코딩 설정
		response.setContentType("text/html;charset=UTF-8");
		
		//브라우저 출력
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head><title>Servlet 시작</title></head>");
		out.println("<body>");
		out.println("<h1 style='color : skyblue'>Servlet 시작하기 - 주영준</h1>");
		out.println("</body>");
		out.println("</html>");
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("LifeCycleServlet doPost 요청.....");
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("LifeCycleServlet service 요청.....");
		
		//전송된 정보를 받기
		String userId = request.getParameter("userId");   //input에 있는 name을 들고온다
		String userName = request.getParameter("userName");
		String userPwd = request.getParameter("userPwd");
		
		System.out.println("userId = "+userId);
		System.out.println("userName = "+userName);
		System.out.println("userPwd = "+userPwd);
	}
	
	@Override
	public void destroy() {
		System.out.println("LifeCycleServlet destroy 요청.....");
	}
	
	@Override
	public void init() throws ServletException {
		System.out.println("LifeCycleServlet init 요청.....");
	}
	
}
