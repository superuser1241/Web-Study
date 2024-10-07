package web.mvc.controller;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * 	모든 요청을 중앙집중적으로 관리해줄 진입점 Controller이다 =FrontController이다
 * */
@WebServlet(urlPatterns = "/front", loadOnStartup = 1)
@MultipartConfig( //어노테이션을 통해  서블릿이 파일 업로드 기능을 할 수 있도록 웹 컨테이너에 지시
        maxFileSize = 1024 * 1024 * 5, //5M - 한 번에 업로드 할 수 있는 파일 크기 제한
       maxRequestSize = 1024 * 1024 * 50 //50M -전체 요청의 크기 제한. 기본값은 무제한 
)
public class DispatcherServlet extends HttpServlet {
	private Map<String, Controller> map;
	private Map<String, Class<?>> classMap;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		//application 영역에 저장된 정보를 조회
		ServletContext application= config.getServletContext();
		map = (Map<String, Controller>)application.getAttribute("map");
		classMap = (Map<String, Class<?>>)application.getAttribute("classMap");
		System.out.println(map);
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//전송된 key 받기
		String key = request.getParameter("key");
		String methodName = request.getParameter("methodName");
		System.out.println(key+" , "+methodName);
		
		try {
			//전달받은 key에 해당하는 Controller를 Map에서 찾아서 호출
			Controller con = map.get(key);
			Class<?> className=classMap.get(key);
			Method method=className.getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class );
			
			ModelAndView mv =(ModelAndView)method.invoke(con,request,response);
			
			if(mv.isRedirect()) {
				response.sendRedirect(mv.getViewName());
			}else {
				request.getRequestDispatcher(mv.getViewName()).forward(request, response);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
