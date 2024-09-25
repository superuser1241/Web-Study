package ex0925_el;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ForEachBean {
	private String names[] = {"윤성","재구","영준","성민","정우"}; 
	private List<String> menus =Arrays.asList("짜장","짬뽕","탕수육","깐풍기");
	
	private List<Board> boardList = new ArrayList<Board>();
	
	private Map<String, String> map = new HashMap<String,String>();
	
	public ForEachBean() {
		System.out.println("ForEachBean 생성자 호출...");
		
		//boardList에 데이터 추가
		boardList.add(new Board(1,"제목1","내용1"));
		boardList.add(new Board(2,"제목2","내용2"));
		boardList.add(new Board(3,"제목3","내용3"));
		boardList.add(new Board(4,"제목4","내용4"));
		boardList.add(new Board(5,"제목5","내용5"));
		
		//map 데이터 추가
		map.put("kr", "대한민국");
		map.put("us", "미국");
		map.put("ch", "중국");
		map.put("jp", "일본");
		map.put("uk", "영국");
		
	}

	public String[] getNames() {//뷰에서 ${이름.names}
		return names;
	}

	public List<String> getMenus() {
		return menus;
	}

	public List<Board> getBoardList() {//뷰에서 ${이름.boardList}
		return boardList;
	}

	public Map<String, String> getMap() {
		return map;
	}
	
}
