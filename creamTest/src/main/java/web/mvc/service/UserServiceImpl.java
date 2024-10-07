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
	@Override
	public UserDTO searchUser(String userId) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int updateUser(UserDTO user) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int deleteUser(String userId) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public String checkRankUser(String userId) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int chargeCash(String userId, int cash) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}
