package gs.goott.signup;

public class MemberVO {
	private int userno;
	private String userid ;
	private String userpwd;
	private String tel;
	private String email;
	private String userImage;
	private String[] interest;
	private String interestStr;
	
	private int myAcorn;
	private int contentPrice;
	private String regdate;
	private int userLevel;
	
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUserpwd() {
		return userpwd;
	}
	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUserImage() {
		return userImage;
	}
	public void setUserImage(String userImage) {
		this.userImage = userImage;
	}
	public String[] getInterest() {
		return interest;
	}
	public void setInterest(String[] interest) {
		this.interest = interest;
		interestStr ="";
		for(int i=0; i<interest.length; i++) {
			interestStr += interest[i]+"/";
			System.out.println("interestStr="+interestStr);
		}
	}
	public String getInterestStr() {
		return interestStr;
	}
	public void setInterestStr(String interestStr) {
		this.interestStr = interestStr;
		interest = interestStr.split("/");
	}
	public int getMyAcorn() {
		return myAcorn;
	}
	public void setMyAcorn(int myAcorn) {
		this.myAcorn = myAcorn;
	}
	public int getContentPrice() {
		return contentPrice;
	}
	public void setContentPrice(int contentPrice) {
		this.contentPrice = contentPrice;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public int getUserLevel() {
		return userLevel;
	}
	public void setUserLevel(int userLevel) {
		this.userLevel = userLevel;
	}
	public int getUserno() {
		return userno;
	}
	public void setUserno(int userno) {
		this.userno = userno;
	}
	
	
	
	
	
	
	
}
