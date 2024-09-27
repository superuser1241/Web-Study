package ex0925;

import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebFilter(urlPatterns = "/LoginOk.jsp", 
initParams = {@WebInitParam(name="saveDir", value="C://Edu//log"),
						@WebInitParam(name="encoding", value="UTF-8")})
public class LoginFilterTest extends HttpFilter implements Filter {
	Log log = LogFactory.getLog(getClass());

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpSession session = req.getSession();
		
		if(session.getAttribute("userId")==null) {
			//오류 페이지로 이동하기 전에 오류메세지 저장
			req.setAttribute("errMsg", "로그인하고 이용해주세요");//뷰에서 ${errMsg}
			req.getRequestDispatcher("error/error.jsp").forward(request, response);
			
			return;// 메소드를 빠져나간다.
		}
		
		chain.doFilter(request, response);//다음 target대상 호출(filter or servlet or jsp)
		
		//사후처리(공통기능)
		System.out.println("LoginFilterTest 사후처리 입니다");
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		log.debug("초기화입니다!");
		filterConfig.getInitParameter(getFilterName());
	}
	
}
