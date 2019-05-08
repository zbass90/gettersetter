package gs.goott.content;

public class ContentVO {
	private int contentNo;
	private String userid;
	private String title;
	private String thumbnail;
	private String filename;
	private String description;
	private int views;
	private String uploadDate;
	private String interest;
	private float videoLength;
	private String videoLengthStr;
	public ContentVO() {}	
	
	public int getContentNo() {
		return contentNo;
	}
	public void setContentNo(int contentNo) {
		this.contentNo = contentNo;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getViews() {
		return views;
	}
	public void setViews(int views) {
		this.views = views;
	}
	public String getUploadDate() {
		return uploadDate;
	}
	public void setUploadDate(String uploadDate) {
		this.uploadDate = uploadDate;
	}

	public String getInterest() {
		return interest;
	}
	public void setInterest(String interest) {
		this.interest = interest;
	}
	public float getVideoLength() {
		return videoLength;
	}
	public void setVideoLength(float videoLength) {
		this.videoLength = videoLength;	
		videoLengthStr = Float.toString(videoLength);
		videoLengthStr = videoLengthStr.replace(".", ":");
	}

	public String getVideoLengthStr() {
		return videoLengthStr;
	}

	public void setVideoLengthStr(String videoLengthStr) {
		this.videoLengthStr = videoLengthStr;		
	}
	
}
