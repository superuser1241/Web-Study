package web.mvc.service;

import java.sql.SQLException;

import web.mvc.dao.UserDAOImpl;
import web.mvc.dto.UserDTO;
import web.mvc.exception.AuthenticationException;

public class UserServiceImpl implements UserService {
	UserDAOImpl dao = new UserDAOImpl();
	@Override
	public UserDTO loginCheck(UserDTO userDTO) throws SQLException, AuthenticationException {
		UserDTO user = dao.loginCheck(userDTO);
		
		if(user!=null) {
			return user;
		}
		else return null;
	}

}
