package web.mvc.dao;

import java.sql.SQLException;
import java.util.List;

import web.mvc.dto.Electronics;

public interface ElectronicsDAO {
	 /**
	  * 레코드 전체 검색
	  * */
	  List<Electronics> selectAll() throws SQLException;
	  
	  /**
		  * 레코드 전체 검색(페이지처리)
		  * */
	   List<Electronics> getBoardList(int pageNo) throws SQLException;
	  
	  /**
	   * 모델번호에 해당하는 레코드 검색
	   * */
	  Electronics selectByModelNum(String modelNum) throws SQLException;
	  
	  /**
	   * 조회수를 증가하는 기능
	   * update Electronics set readnum = readnum + 1 where model_num=?
	   * */
	  int increamentByReadnum(String modelNum) throws SQLException;
	  
	  
	/**
	 * 레코드 삽입
	 * @return : 1-삽입성공 , 0 - 삽입실패
	 * */
	  int insert(Electronics electronics) throws SQLException;
	  
	  /**
	   * 모델번호에 해당하는 레코드 삭제
	   * @return : 1-삭제성공 , 0 - 삭제실패
	   * */
	  int delete(String modelNum, String password) throws SQLException;
	  
	   /**
	    * 모델번호에 해당하는 레코드 수정
	    * @return : 1-수정성공 , 0 - 수정실패
	    * */
	  int update(Electronics electronics) throws SQLException;
}
