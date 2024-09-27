package ex0926.servlet;

import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns = "/b", loadOnStartup = 1,
	initParams = {
		@WebInitParam(name="fileName", value="test.jpg"), 
		@WebInitParam(name="message" , value="hi")
		})
public class TestServlet extends HttpServlet {
	Log log = LogFactory.getLog(getClass());
	@Override
	public void init(ServletConfig config) throws ServletException {
		String fileName = config.getInitParameter("fileName");
		String message = config.getInitParameter("message");
		String id = config.getInitParameter("id");
		
		log.info("초기화됨..." + fileName+"/"+message+"/"+id);
		
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
}
