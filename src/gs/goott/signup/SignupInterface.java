
package gs.goott.signup;

import java.util.List;

public interface SignupInterface {
	//�α���üũ
	public int loginCheck(String userid,String userpwd) ;
	//���̵��ߺ��˻�
	public int idCheck(String userid);
	//ȸ�����
	public int signup(MemberVO vo);
	//ȸ������
	public int profileUpdate(String userid, String data, String type);
	//ȸ��Ż��
	public int profileDelete(String userid);
	//ȸ�� ������������
	public MemberVO getUserInfo(String userid);
	//���丮����		
	public int buyAcorn(String userid,int buyAcorn, int myAcorn);	
	//���丮 ����
	public int useAcorn(String userid,Double price);
	//��� ������ ���� ��������
	public List<MemberVO> getAllUser();
	

	
	
}