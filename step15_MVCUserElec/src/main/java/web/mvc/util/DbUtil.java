package web.mvc.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

/**
 * DB연동을 위한 로드 연결 닫기
 *  : DBCP기술 적용 (context.xml 참조)
 * */
public class DbUtil {
    private static DataSource ds;
    
	/**
	 * 로드
	 * */
	static {
		try {
			/*Context initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			 ds = (DataSource)envContext.lookup("jdbc/myoracle");*/
			
			Context initContext = new InitialContext();
			ds=(DataSource)initContext.lookup("java:/comp/env/jdbc/myoracle");
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}//static 끝
	

	
	/**
	 * 연결
	 * */
	public static Connection getConnection() throws SQLException {
		Connection conn = ds.getConnection();
		return conn;
	}
	
	/**
	 * 닫기  - 사용된 객체 닫기- select인경우 
	 * */
    public static void dbClose(Connection con , Statement st , ResultSet rs) {
    	try {
		  if(rs!=null)rs.close();
	      dbClose(con, st);
    	}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 닫기  - 사용된 객체 닫기- DML or DDL 인경우 
	 * */
	public static void dbClose(Connection con , Statement st) {
		try {
			if(st != null)st.close();
			if(con!=null)con.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}//classEnd










