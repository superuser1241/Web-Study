package ex0925_el;

public class Board {
	private int no;
	private String subject;
	private String content;
	
	public Board() {}
	public Board(int no, String subject, String content) {
		super();
		this.no = no;
		this.subject = subject;
		this.content = content;
	}
	public int getNo() {//뷰에서 ${이름.no}
		return no;
	}

	public String getSubject() {//${이름.subject}
		return subject;
	}

	public String getContent() {
		return content;
	}

	
}
