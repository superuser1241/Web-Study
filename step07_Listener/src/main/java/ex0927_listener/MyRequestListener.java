package ex0927_listener;

import jakarta.servlet.ServletRequestEvent;
import jakarta.servlet.ServletRequestListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class MyRequestListener implements ServletRequestListener {
	
	 @Override
	 public void requestInitialized(ServletRequestEvent sre) {
		// 요청이 초기화될 때 실행할 코드
		 System.out.println("MyRequestListener requestInitialized...");
		 
	 }
	 @Override
	 public void requestDestroyed(ServletRequestEvent sre) {
		// 요청이 완료되었을 때 실행할 코드
		 System.out.println("MyRequestListener requestDestroyed...");
		 
	 }
}
