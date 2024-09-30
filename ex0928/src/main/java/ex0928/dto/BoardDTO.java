package ex0928.dto;

public class BoardDTO {
   private int no;
   private String subject;
   private String content;
   
   public BoardDTO() {}
   public BoardDTO(int no, String subject, String content) {
	super();
	this.no = no;
	this.subject = subject;
	this.content = content;
  }
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
   
}
