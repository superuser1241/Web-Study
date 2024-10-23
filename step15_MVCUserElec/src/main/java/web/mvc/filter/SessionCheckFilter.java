package web.mvc.filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import web.mvc.controller.ModelAndView;

@WebFilter("/front")
public class SessionCheckFilter extends HttpFilter implements Filter {
       
    public SessionCheckFilter() {
    	
    }

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		HttpSession session = httpRequest.getSession(false);
		
		
		String key = httpRequest.getParameter("key");
		String methodName = httpRequest.getParameter("methodName");
		
		
		//로그인 화면에서 예외처리 안해주면 로그인 화면에서도 filter때문에 화면이 안넘어감;
		if (key.equals("user") && methodName.equals("login")) {
			chain.doFilter(request, response); 
			return;	
		}
		
		if (session == null || session.getAttribute("loginUser") == null) {
			httpResponse.sendRedirect("user/login.jsp");
			return;
		}
		
		chain.doFilter(request, response);
	}


}
