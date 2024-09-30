package ex0930.dao;

import java.sql.SQLException;
import java.util.List;

import ex0930.dto.MemberDTO;

public interface MemberDAO {
  /**
   * 전체검색
   * select id,pwd,name, age, phone, addr, join_date 
      from member order by join_date desc
 * @throws SQLException 
   *  
   * */
	List<MemberDTO> selectAll() throws SQLException;
	
  /**
   * 회원가입 = 등록
   * insert into member(id,pwd,name,age,phone,addr, join_date)
     values(?,?,?,?,?,?, sysdate)
 * @throws SQLException 
   * */
	int insert(MemberDTO memberDTO) throws SQLException;
	
  /**
   * 상세보기 (id에 해당하는 회원정보 검색)
   * select id,pwd,name, age, phone, addr, join_date 
      from member where id=?
 * @throws SQLException 
   * */
	MemberDTO getSelectById(String id) throws SQLException;
	
	
  /**
   *  id에 해당하는 회원 삭제하기
   *  delete from member where id=?
 * @throws SQLException 
   * */	
   int delete(String id) throws SQLException;
   
	
   /**
    * id에 해당하는 정보 수정하기(비번, 나이, 주소, 연락처 )
    * update member set pwd=? , age=? , addr=? ,phone=?
    * where id=?
    * */
   int update(MemberDTO memberDTO);
	
   /**
	* 조건검색 ( keyField, keyWord에 해당하는 조건검색)
	*  SELECT id,pwd,name, age, phone, addr, join_date  FROM MEMBER  WHERE id LIKE ?
	*  SELECT id,pwd,name, age, phone, addr, join_date  FROM MEMBER  WHERE name LIKE ?
	*  SELECT id,pwd,name, age, phone, addr, join_date  FROM MEMBER  WHERE addr LIKE ?
 * @throws SQLException 
	* */
    List<MemberDTO> findBykeyFieldWord(String keyField, String keyWord) throws SQLException;
	
}





