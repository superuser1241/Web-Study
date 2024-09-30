package ex0930.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ex0930.dto.MemberDTO;

public class MemberDAOImpl implements MemberDAO {

	@Override
public List<MemberDTO> selectAll() throws SQLException{
		String sql = "select id,pwd,name, age, phone, addr, join_date from member order by join_date desc";	
		
		List<MemberDTO> memberList = new ArrayList<MemberDTO>();
		MemberDTO member = new MemberDTO();
		
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs = null;
		
		try {
			con = DBManager.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()) {
            	member = new MemberDTO(
            			rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7));
            	
            	memberList.add(member);
            }
		}
		finally {
			DBManager.dbClose(con, ps,rs);
		}
		return memberList;
	}

	@Override
	public int insert(MemberDTO memberDTO) throws SQLException{
		String sql = "insert into member(id,pwd,name,age,phone,addr, join_date)values(?,?,?,?,?,?, sysdate)";
		Connection con = null;
	    PreparedStatement ps = null;
	    int result = 0;
	    
	    try {
	    	con = DBManager.getConnection();
	    	ps = con.prepareStatement(sql);
	    	
	    	ps.setString(1,memberDTO.getId());
	    	ps.setString(2,memberDTO.getPwd());
	    	ps.setString(3,memberDTO.getName());
	    	ps.setInt(4,memberDTO.getAge());
	    	ps.setString(5,memberDTO.getPhone());
	    	ps.setString(6,memberDTO.getAddr());
	    	
	    	result = ps.executeUpdate();
	    }
	    finally {
	    	DBManager.dbClose(con, ps);
	    }
		
		return result;
	}

	@Override
	public MemberDTO getSelectById(String id) throws SQLException{
		String sql="select id,pwd,name, age, phone, addr, join_date from member where id=?";
		MemberDTO member = null;
		Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
        	con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			
			if (rs.next()) { 
	            member = new MemberDTO(
	            		rs.getString(1),
	                    rs.getString(2),
	                    rs.getString(3),
	                    rs.getInt(4),
	                    rs.getString(5),
	                    rs.getString(6)
	            );
	        }
        }
        finally {
        	DBManager.dbClose(con, ps, rs);
        }
        
		return member;
	}

	@Override
	public int delete(String id) throws SQLException{
		String sql ="delete from member where id=?";
		int result = 0;
        Connection con = null;
        PreparedStatement ps = null;
        
        try {
        	con = DBManager.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, id);
            result = ps.executeUpdate();
        }
        finally {
        	DBManager.dbClose(con, ps);
        }
		
		return result;
	}

	@Override
	public int update(MemberDTO memberDTO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<MemberDTO> findBykeyFieldWord(String keyField, String keyWord) throws SQLException{
		String sql ="SELECT id,pwd,name, age, phone, addr, join_date  FROM MEMBER  WHERE "+ keyField +" LIKE ?";
		List<MemberDTO> memberList = new ArrayList<>();
	    MemberDTO member = null;

	    Connection con = null;
	    PreparedStatement ps = null;
	    ResultSet rs = null;
	    
		try {
			con = DBManager.getConnection();
	        ps = con.prepareStatement(sql);
	        ps.setString(1, keyWord);
	        rs = ps.executeQuery();
	        
	        while (rs.next()) {
	            member = new MemberDTO(
	                rs.getString(1),
	                rs.getString(2),
	                rs.getString(3),
	                rs.getInt(4),
	                rs.getString(5),
	                rs.getString(6),
	                rs.getString(7)
	            );
	            memberList.add(member);
	        }

		}finally {
			DBManager.dbClose(con, ps, rs);
		}
		return memberList;
	}
}
