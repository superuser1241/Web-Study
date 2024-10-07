package web.mvc.listener;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import web.mvc.controller.Controller;

@WebListener
public class HandleMappingListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent e) {
		Map<String, Controller> map = new HashMap<String, Controller>();
		Map<String, Class<?>> classMap = new HashMap<String, Class<?>>();
		
		//외부의 ~.properties파일 로딩
		ResourceBundle rb = ResourceBundle.getBundle("actionMapping");
		try {
			for(String key : rb.keySet()) {
				String value = rb.getString(key);
				
				Class<?> className=Class.forName(value);
				Controller con =(Controller)className.getDeclaredConstructor().newInstance();
				
				System.out.println(key+" = "+value+"/"+con);
				map.put(key, con);
				classMap.put(key, className);
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		//map을 application영역에 저장한다
		ServletContext application = e.getServletContext();
		application.setAttribute("map", map);
		application.setAttribute("classMap", classMap);
		application.setAttribute("path", application.getContextPath());
		
	}//메소드 끝
}
