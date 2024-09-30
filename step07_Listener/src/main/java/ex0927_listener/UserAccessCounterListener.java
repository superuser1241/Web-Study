package ex0927_listener;

import java.util.concurrent.atomic.AtomicInteger;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

@WebListener
public class UserAccessCounterListener implements ServletContextListener, HttpSessionListener {
	
	ServletContext application;
	/**
	 * 	서버가 시작될 때  applicationScope영역에 nowCounter값을 초기화한다. - AtomicInteger()
	 * */
	public void contextInitialized(ServletContextEvent e)  { 
		application = e.getServletContext();
        application.setAttribute("nowCounter", new AtomicInteger());
	}
	
	/**
	 * 	nowCounter의 값을 1 증가
	 * */
    public void sessionCreated(HttpSessionEvent e)  { 
    	AtomicInteger at = (AtomicInteger)application.getAttribute("nowCounter");
    	int nowCounter = at.incrementAndGet();
    	System.out.println("증가된 후(현재 접속자수)=" + nowCounter);
    }
    
    /**
     * 	nowCounter의 값을 1 감소
     * */
    public void sessionDestroyed(HttpSessionEvent e)  { 
    	AtomicInteger at = (AtomicInteger)application.getAttribute("nowCounter");
    	int nowCounter = at.decrementAndGet();
    	System.out.println("감소된 후(현재 접속자수)="+ nowCounter);
    }
    
    /**
     * 	
     * */
    public void contextDestroyed(ServletContextEvent e)  { 
    	
    }
	
}
