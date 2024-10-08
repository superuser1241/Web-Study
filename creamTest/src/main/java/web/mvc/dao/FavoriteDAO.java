package web.mvc.dao;

import java.sql.SQLException;
import java.util.List;

import web.mvc.dto.Product;

public interface FavoriteDAO {
	/**
	 * 	찜 목록 추가(한개씩)
	 * */
	int addFavorite(String userId, String productId) throws SQLException;
	
	/**
	 * 	찜 목록 조회(리스트로)
	 * */
	List<Product> getFavoritesByUser(String userId) throws SQLException;
	
	/**
	 * 	찜 목록에서 삭제	
	 * */
	int deleteFavorite(String favoriteId) throws SQLException;
}
