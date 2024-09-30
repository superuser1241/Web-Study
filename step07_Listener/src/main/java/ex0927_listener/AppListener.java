package ex0927_listener;

import java.util.concurrent.atomic.AtomicInteger;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

public class AppListener implements ServletContextListener {
	
	public AppListener() {
		System.out.println("AppListener constructor....");
		
	}
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("AppListener contextInitialized....");
		
		//서버가 시작과 동시에 contextPath를 application영역에 저장
				ServletContext application = sce.getServletContext();
				application.setAttribute("path", application.getContextPath());
				
				application.setAttribute("count", new AtomicInteger());	
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("AppListener contextDestroyed....");
	}
	
}
