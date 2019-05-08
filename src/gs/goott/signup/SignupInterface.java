
package gs.goott.signup;

import java.util.List;

public interface SignupInterface {
	//로그인체크
	public int loginCheck(String userid,String userpwd) ;
	//아이디중복검사
	public int idCheck(String userid);
	//회원등록
	public int signup(MemberVO vo);
	//회원수정
	public int profileUpdate(String userid, String data, String type);
	//회원탈퇴
	public int profileDelete(String userid);
	//회원 정보가져오기
	public MemberVO getUserInfo(String userid);
	//도토리충전		
	public int buyAcorn(String userid,int buyAcorn, int myAcorn);	
	//도토리 차감
	public int useAcorn(String userid,Double price);
	//모든 유저들 정보 가져오기
	public List<MemberVO> getAllUser();
	

	
	
}