	package web.mvc.service;
	
	import java.sql.SQLException;
	import java.util.List;
	
	import web.mvc.dao.ElectronicsDAO;
	import web.mvc.dao.ElectronicsDAOImpl;
	import web.mvc.dto.Electronics;
	
	public class ElectronicsServiceImpl implements ElectronicsDAO {
		ElectronicsDAOImpl dao = new ElectronicsDAOImpl();
		
		@Override
		public List<Electronics> selectAll() throws SQLException {
			List<Electronics> list=dao.selectAll();
			
			return list;
		}
	
		@Override
		public List<Electronics> getBoardList(int pageNo) throws SQLException {
			List<Electronics> list = dao.getBoardList(pageNo);
			
			return list;
		}
	
		@Override
		public Electronics selectByModelNum(String modelNum) throws SQLException {
			Electronics electronics=dao.selectByModelNum(modelNum);
			
			return electronics;
		}
	
		@Override
		public int increamentByReadnum(String modelNum) throws SQLException {
			int result = dao.increamentByReadnum(modelNum);
			
			return result;
		}
	
		@Override
		public int insert(Electronics electronics) throws SQLException {
			int result=dao.insert(electronics);
			
			return result;
		}
	
		@Override
		public int delete(String modelNum, String password) throws SQLException {
			int result = dao.delete(modelNum,password);
			
			return result;
		}
	
		@Override
		public int update(Electronics electronics) throws SQLException {
			int result=dao.update(electronics);
			
			return result;
		}
	
	}
