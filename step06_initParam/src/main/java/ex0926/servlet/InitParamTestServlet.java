package ex0926.servlet;

import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class InitParamTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Log log =LogFactory.getLog(getClass());
	
	String id,pwd;
	public void init(ServletConfig config) throws ServletException {
		log.info("초기화 완성!");
		id = config.getInitParameter("id");
		pwd = config.getInitParameter("pwd");
		
		log.info(id + " / "+pwd);
		
		//ServletContext에 저장된 initParam 가져오기
		ServletContext application= config.getServletContext();
		//String msg application.getInitParameter("message");
		String id = config.getInitParameter("id");
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.info("요청됨..."+id + " / "+pwd);
	}

}
