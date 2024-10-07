package web.mvc.dao;

import java.sql.SQLException;

import web.mvc.dto.UserDTO;

public interface UserDAO {
	
	/**
	 *		회원가입
	 * */
	
	
	
  /**
   * 로그인 기능
   * select user_id , pwd, name from users where user_id=? and pwd=?
   * */
	UserDTO loginCheck(UserDTO userDTO)throws SQLException;
	
	/**
	 * 	회원정보조회
	 * */
	UserDTO getUserById(String userId) throws SQLException;
	
	/**
	 * 	회원정보 수정
	 * */
	int updateUser(UserDTO user) throws SQLException;
	
	/**
	 * 	회원탈퇴
	 * */
	int deleteUser(String userId) throws SQLException;
	
	/**
	 * 	회원 등급 확인
	 * */
	String getUserRank(String userId) throws SQLException;
	
	/**
	 * 	현금 충전
	 * */
	int updateCash(String userId, int cash) throws SQLException;
}
