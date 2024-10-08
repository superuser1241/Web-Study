package mvc.ajax.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import mvc.ajax.dto.CustomerDTO;
import mvc.ajax.util.DbUtil;

public class CustomerDAOImpl implements CustomerDAO {
	@Override
	 public boolean idCheck(String id) {
	  PreparedStatement ps = null;
	  ResultSet rs = null;
	  Connection con = null;
	  boolean result=false;
	  try {
	   con=DbUtil.getConnection();
	   ps = con.prepareStatement("select id from customer where id=?");
	   ps.setString(1, id);
	   rs = ps.executeQuery();
	   if(rs.next()){
	    result=true;
	   }
	  } catch (SQLException e) {
	    e.printStackTrace();
	  }finally {
	    DbUtil.dbClose(rs, ps, con);
	  }
	  return result;
	 }

	 @Override
	 public int insert(CustomerDTO dto) {
	  PreparedStatement ps = null;
	  Connection con = null;
	  int result=0;
	  try {
	   con = DbUtil.getConnection();
	   ps = con.prepareStatement("insert into customer(id,name,age,tel,addr) values(?,?,?,?,?)");
	   ps.setString(1, dto.getId());
	   ps.setString(2, dto.getName());
	   ps.setInt(3, dto.getAge());
	   ps.setString(4, dto.getTel());
	   ps.setString(5, dto.getAddr());
	   result = ps.executeUpdate();
	  } catch (SQLException e) {
	   e.printStackTrace();
	  } finally {
	   DbUtil.dbClose( ps, con);
	  }
	  return result;
	 }

	 @Override
	 public List<CustomerDTO> selectAll() {
	  Connection con = null;
	  PreparedStatement ps = null;
	  ResultSet rs = null;
	  List<CustomerDTO> list = new ArrayList<CustomerDTO>();
	  try {
	   con = DbUtil.getConnection();
	   ps = con.prepareStatement("select * from customer order by id");
	   rs  = ps.executeQuery();
	   while(rs.next()){
	    list.add(new CustomerDTO(rs.getString(1), rs.getString(2), rs.getInt(3), 
	      rs.getString(4), rs.getString(5)));
	   }

	  } catch (SQLException e) {
	   e.printStackTrace();
	  } finally {
	   DbUtil.dbClose(rs, ps, con);
	  }
	  return list;
	 }

	 @Override
	 public int delete(String id) {
	  PreparedStatement ps = null;
	  Connection con =null;
	  int result=0;
	  try {
	   con = DbUtil.getConnection();
	   ps = con.prepareStatement("delete from customer where id=?");
	   ps.setString(1, id);
	   result = ps.executeUpdate();
	  } catch (SQLException e) {
	   e.printStackTrace();
	  } finally {
	   DbUtil.dbClose( ps, con);
	  }
	  return result;
	 }

	 @Override
	 public int update(CustomerDTO customerDTO) {
	  PreparedStatement ps = null;
	  Connection con =null;
	  int result=0;
	  try {
	   con = DbUtil.getConnection();
	   ps = con.prepareStatement("update customer set name=?,age=?,tel=?,addr=? where id=?");
	   
	   ps.setString(1, customerDTO.getName());
	   ps.setInt(2, customerDTO.getAge());
	   ps.setString(3, customerDTO.getTel());
	   ps.setString(4, customerDTO.getAddr());
	   ps.setString(5, customerDTO.getId());
	   
	   result = ps.executeUpdate();
	  } catch (SQLException e) {
	   e.printStackTrace();
	  } finally {
	   DbUtil.dbClose( ps , con);
	  }
	  return result;
	 }


}
