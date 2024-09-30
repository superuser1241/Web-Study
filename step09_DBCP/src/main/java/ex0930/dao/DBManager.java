package ex0930.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

/**
 * 	DBCP 연동을 위한 로드, 연결, 실행, 닫기
 * 	: JNDI Datasource 방법으로 연동
 * */
public class DBManager {
	private static DataSource ds;
	static {
		try {
			Context initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");// JNDI Datasource를 위한 name(이건 정해져있다)
			ds = (DataSource)envContext.lookup("jdbc/myoracle");//context.xml에 설정
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	/**
	 * 	연결 객체 리턴해주는 메소드 작성
	 * */
	public static Connection getConnection() throws SQLException{
		return ds.getConnection();
	}
	
	/**
	 * 	닫기 기능(select인 경우)
	 * */
	
	public static void dbClose(Connection con, Statement st, ResultSet rs) {
		try {
			if(rs!=null)rs.close();
			dbClose(con, st);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 	닫기 기능(DML인 경우)
	 * */
	public static void dbClose(Connection con, Statement st) {
		try {
			if(st!=null)st.close();
			if(con!=null)con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
