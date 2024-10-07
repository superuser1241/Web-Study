 package web.mvc.service;

import java.sql.SQLException;

import web.mvc.dto.UserDTO;
import web.mvc.exception.AuthenticationException;

public interface UserService {
	/**
	 * 로그인 체크
	 * */
   UserDTO loginCheck(UserDTO userDTO)throws SQLException , AuthenticationException;
}
