package ex0925;

import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;

@WebFilter(urlPatterns = "/*")
public class LogFilter extends HttpFilter implements Filter {
	Log log = LogFactory.getLog(getClass());

    public LogFilter() {

    }

	public void destroy() {

	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		
        String clientIp = req.getRemoteAddr();
        String requestUrl = req.getRequestURL().toString();
        long startTime = System.currentTimeMillis();
        
        log.debug("ip: "+clientIp+", requestUrl"+requestUrl);
        
        chain.doFilter(request, response);
        long endTime = System.currentTimeMillis();
        log.debug("총 소요 ms: "+ (endTime - startTime)+"ms");
	}

	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
