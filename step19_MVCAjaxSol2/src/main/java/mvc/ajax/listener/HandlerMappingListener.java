package mvc.ajax.listener;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import mvc.ajax.controller.RestController;



/**
 * 
 * 서버가 start될때 각각의 Controller의 구현체를 미리 생성해서 Map저장 
 */
@WebListener
public class HandlerMappingListener implements ServletContextListener {
    public void contextInitialized(ServletContextEvent e)  { 
        Map<String, RestController> map = new HashMap<String, RestController>();
        Map<String, Class<?> > clzMap = new HashMap<String, Class<?>>();
        
        //~.properties파일 로딩
       ResourceBundle rb = ResourceBundle.getBundle("ajaxMapping"); //resources/ajaxMapping.properties
       
        try {
	        for(String key : rb.keySet()) {
	        	String value = rb.getString(key);
	        	//System.out.println(key +" = " + value );
	        	
	        	//String의 문자열을 Controller의 객체로 생성해야한다!!!
	        	//Class<?>는 어떤 객체가 가지고 있는 필드, 생성자, 메소드의 정보를 동적으로 가져올수 있도록 도와주는 객체이다 - reflection 개념
	    		//reflection 개념은 동적으로 즉 실행도중에 필요한 객체를 적절하게 생성하고 그 객체가 가지고 있는 생성자나 메소드를 
	    		//동적으로 호출해줄수 있도록 하는 개념을 reflection이라고 하고 자바에서 이 개념을 적용해 놓은 API가 Class<?> 이다.
	
	        	Class<?> className = Class.forName(value);
	        	RestController controller = (RestController)className.getDeclaredConstructor().newInstance();
	        	
	        	System.out.println("controller = " + controller);
	        	
	        	map.put(key, controller); 
	        	clzMap.put(key, className);
	        }
        }catch (Exception ex) {
			ex.printStackTrace();
		}
        
        //모든 영역에서 map을 사용할수 있도록 ServletContext영역에 저장한다.
        ServletContext application = e.getServletContext();
        application.setAttribute("ajaxMap", map);
        application.setAttribute("ajaxClzMap", clzMap);
       
    }//메소드끝
	
}//classEnd







