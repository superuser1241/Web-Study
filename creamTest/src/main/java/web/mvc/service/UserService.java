 package web.mvc.service;

import java.sql.SQLException;

import web.mvc.dto.UserDTO;
import web.mvc.exception.AuthenticationException;

public interface UserService {
	/**
	 * 	회원가입
	 * */
	
	
	
	/**
	 * 로그인 체크
	 * */
   UserDTO loginCheck(UserDTO userDTO)throws SQLException , AuthenticationException;
   
   /**
    * 		회원정보 조회
    * */
   UserDTO searchUser(String userId) throws SQLException;
   
   /**
    * 		회원정보 수정
    * */
   int updateUser(UserDTO user) throws SQLException;
   
   /**
    * 		회원탈퇴
    * */
   int deleteUser(String userId) throws SQLException;
   
   /**
	 * 	회원 등급 확인
	 * */
	String checkRankUser(String userId) throws SQLException;
	
	/**
	 * 	현금 충전
	 * */
	int chargeCash(String userId, int cash) throws SQLException;
}
