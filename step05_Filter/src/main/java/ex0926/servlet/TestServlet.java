package ex0926.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/test" ,loadOnStartup = 1)
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public TestServlet() {
        
    }


	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("여기는 TestServlet입니다!");
	}
    

}
