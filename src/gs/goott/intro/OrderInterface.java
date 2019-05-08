package gs.goott.intro;

import java.util.List;

public interface OrderInterface  {
	//추가	
	public int orderContent(String setterId, String getterId, Double price); 

	//샀는지 안샀는지 확인 
	public List<OrderVO> checkOrderList(String userid);
	
	public OrderVO orderInfo(String sertterId);
	public List<IntroVO> orderList(String userid);
	public int orderCheck(String introid, String userid);
}
