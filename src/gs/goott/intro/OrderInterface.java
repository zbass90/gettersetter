package gs.goott.intro;

import java.util.List;

public interface OrderInterface  {
	//�߰�	
	public int orderContent(String setterId, String getterId, Double price); 

	//����� �Ȼ���� Ȯ�� 
	public List<OrderVO> checkOrderList(String userid);
	
	public OrderVO orderInfo(String sertterId);
	public List<IntroVO> orderList(String userid);
	public int orderCheck(String introid, String userid);
}
