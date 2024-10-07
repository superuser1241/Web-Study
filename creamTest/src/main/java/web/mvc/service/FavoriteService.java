package web.mvc.service;

import java.sql.SQLException;
import java.util.List;

import web.mvc.dto.Product;

public interface FavoriteService {
	/**
	 * 	찜 목록 추가
	 * */
	int addFavoriteItem(String userId, String productId) throws SQLException;
	
	/**
	 * 	찜 목록 조회
	 * */
	List<Product> favoriteItems(String userId) throws SQLException;
	
	/**
	 * 	찜 목록에서 삭제
	 * */
	int deleteFavoriteItems(String favoriteId) throws SQLException;
}
