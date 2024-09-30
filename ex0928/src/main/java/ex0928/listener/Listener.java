package ex0928.listener;

import java.util.ArrayList;
import java.util.List;

import ex0928.dto.BoardDTO;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

public class Listener implements ServletContextListener {


    public Listener() {
       
    }

    public void contextInitialized(ServletContextEvent e)  { 
    	List<BoardDTO> boardList = new ArrayList<>();
        boardList.add(new BoardDTO(1, "음율", "반비례"));
        boardList.add(new BoardDTO(2, "달의하루", "너로피어오라"));
        boardList.add(new BoardDTO(3, "데이식스", "한페이지가 될수있게"));
        
        ServletContext application = e.getServletContext();
        application.setAttribute("boardList", boardList);
    }	
    
    public void contextDestroyed(ServletContextEvent sce)  { 
        System.out.println("Listener contextDestroyed....");
    }
	
}
