package web.mvc.dto;

public class Reply {
   private int replyNum;
   private String replyContent;
   private String replyRegdate;
   private String parentModelNum;
   
   public Reply() {}
   public Reply(int replyNum, String replyContent, String replyRegdate, String parentModelNum) {
	super();
	this.replyNum = replyNum;
	this.replyContent = replyContent;
	this.replyRegdate = replyRegdate;
	this.parentModelNum = parentModelNum;
  }
   
	public int getReplyNum() {
		return replyNum;
	}
	public void setReplyNum(int replyNum) {
		this.replyNum = replyNum;
	}
	public String getReplyContent() {
		return replyContent;
	}
	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}
	public String getReplyRegdate() {
		return replyRegdate;
	}
	public void setReplyRegdate(String replyRegdate) {
		this.replyRegdate = replyRegdate;
	}
	public String getParentModelNum() {
		return parentModelNum;
	}
	public void setParentModelNum(String parentModelNum) {
		this.parentModelNum = parentModelNum;
	}
	   
   
   
}



