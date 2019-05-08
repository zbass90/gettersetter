package gs.goott.intro;

public class replyVO {

	private int introNo;
	private int commentNo;	
	private String commenter;
	private String commentContent;
	private String commentDate;
	private Double star;
	public int getIntroNo() {
		return introNo;
	}
	public void setIntroNo(int introNo) {
		this.introNo = introNo;
	}
	public int getCommentNo() {
		return commentNo;
	}
	public void setCommentNo(int commentNo) {
		this.commentNo = commentNo;
	}
	public String getCommenter() {
		return commenter;
	}
	public void setCommenter(String commenter) {
		this.commenter = commenter;
	}
	public String getCommentContent() {
		return commentContent;
	}
	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}
	public String getCommentDate() {
		return commentDate;
	}
	public void setCommentDate(String commentDate) {
		this.commentDate = commentDate;
	}
	public Double getStar() {
		return star;
	}
	public void setStar(Double star) {
		this.star = star;
	}
	
	
}
