package gs.goott.intro;

public class IntroVO {
	private int introNo;
	private String userid;
	private String filename;
	private String[] interest;
	private String interestStr;
	private String description;
	private String introdate;
	private String thumbnail;
	private String thumbnailFileName;
	private String title;
	private int follower;
	private Double price;
	private String beforeFileName;
	private String beforeThumbnail;
	private int totalStar;
	private int oneStar;
	private int twoStar;
	private int threeStar;
	private int fourStar;
	private int fiveStar;
	public IntroVO() {}
	public int getIntroNo() {
		return introNo;
	}
	public void setIntroNo(int introNo) {
		this.introNo = introNo;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String[] getInterest() {
		return interest;
	}	
	public void setInterest(String[] interest) {
		this.interest = interest;
		interestStr="";
		for(int i=0;i<interest.length;i++) {
			if(interest.length-1==i) {
				interestStr +=interest[i];
			}else {
				interestStr +=interest[i]+"/";
			}				
		}
	}
	public String getInterestStr() {
		return interestStr;
	}
	public void setInterestStr(String interestStr) {
		this.interestStr = interestStr;
		interest = interestStr.split("/");
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getIntrodate() {
		return introdate;
	}
	public void setIntrodate(String introdate) {
		this.introdate = introdate;
	}
	public String getThumbnail() {
		return thumbnail;
	}
	
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getFollower() {
		return follower;
	}
	public void setFollower(int follower) {
		this.follower = follower;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getThumbnailFileName() {
		return thumbnailFileName;
	}
	public void setThumbnailFileName(String thumbnailFileName) {
		this.thumbnailFileName = thumbnailFileName;
	}
	public String getBeforeFileName() {
		return beforeFileName;
	}
	public void setBeforeFileName(String beforeFileName) {
		this.beforeFileName = beforeFileName;
	}
	public String getBeforeThumbnail() {
		return beforeThumbnail;
	}
	public void setBeforeThumbnail(String beforeThumbnail) {
		this.beforeThumbnail = beforeThumbnail;
	}
	public int getTotalStar() {
		return totalStar;
	}
	public void setTotalStar(int totalStar) {
		this.totalStar = totalStar;
	}
	public int getOneStar() {
		return oneStar;
	}
	public void setOneStar(int oneStar) {
		this.oneStar = oneStar;
	}
	public int getTwoStar() {
		return twoStar;
	}
	public void setTwoStar(int twoStar) {
		this.twoStar = twoStar;
	}
	public int getThreeStar() {
		return threeStar;
	}
	public void setThreeStar(int threeStar) {
		this.threeStar = threeStar;
	}
	public int getFourStar() {
		return fourStar;
	}
	public void setFourStar(int fourStar) {
		this.fourStar = fourStar;
	}
	public int getFiveStar() {
		return fiveStar;
	}
	public void setFiveStar(int fiveStar) {
		this.fiveStar = fiveStar;
	}
	
	
}
