package web.mvc.service;

import java.sql.SQLException;
import java.util.List;

import web.mvc.dto.Electronics;

public interface ElectronicsService{
	/**
	 * ElectronicsDAOImpl의 모든레코드 검색하는 메소드 호출
	 * */
    List<Electronics> selectAll() throws SQLException;
    
    /**
	 * paging처리
	 * */
    List<Electronics> selectAll(int pageNo) throws SQLException;
	  
	  /**
	   * ElectronicsDAOImpl의 레코드 삽입하는 메소드 호출
	   * */
	  void insert(Electronics electronics) throws SQLException;
	 
	  
	  /**
	   * ElectronicsDAOImpl의 모델번호에 해당하는 레코드 검색하는 메소드 호출
	   * @param : boolean flag - 조회수 증가 여부를 판별하는 매개변수임(true이면 조회수증가 / false이면 조회수 증가 안함)
	   * */
	  Electronics selectByModelnum(String modelNum, boolean flag)
			throws SQLException;
		 
		 
	 /**
	   * ElectronicsDAOImpl의 모델번호에 해당하는 레코드 삭제 메소드 호출
	   * */
	    void delete(String modelNum, String password, String saveDir) throws SQLException;
	  
	  
	  /**
	   * ElectronicsDAOImpl의 모델번호에 해당하는 레코드 수정  메소드 호출
	   * */
	   void update(Electronics electronics) throws SQLException;
	  
}
