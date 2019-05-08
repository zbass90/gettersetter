package gs.goott.intro.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import gs.goott.controller.CommandService;
import gs.goott.intro.IntroDAO;
import gs.goott.intro.IntroVO;
import gs.goott.intro.OrderDAO;
import gs.goott.intro.OrderVO;
import gs.goott.signup.MemberDAO;
import gs.goott.signup.MemberVO;

public class CommandBuy implements CommandService {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		
		int introNo = Integer.parseInt(req.getParameter("introNo"));
		//userid 의 아콘수 
		HttpSession session = req.getSession();
		String userid = (String)session.getAttribute("userid");
		MemberDAO memberDao = new MemberDAO();
		MemberVO memberVo = memberDao.getUserInfo(userid);
		int myAcorn = memberVo.getMyAcorn();
		//introNo 의 가격
		IntroDAO introDao = new IntroDAO();
		IntroVO introVo = introDao.getIntro(introNo);
		Double price = introVo.getPrice();
		
		/////////여러경우의수
		int cnt = 0;
		//이미산거아니니?
		OrderDAO orderDao = new OrderDAO();
		List<OrderVO> orderList = orderDao.checkOrderList(userid);
		String orderedSetterId ="";
		String nowSetterId ="";
		for(int i=0; i<orderList.size();i++) {
				//내가 산 세터들의 아이디
			orderedSetterId = orderList.get(i).getSetterId();
			nowSetterId = introVo.getUserid();
			System.out.println("orderedSetterId"+orderedSetterId);
			System.out.println("nowSetterId"+nowSetterId);
			if(orderedSetterId.equals(nowSetterId)) {
				cnt=2;
				System.out.println("cnt+"+cnt);
			}
		}
		// 잔액이 부족하다
		System.out.print("잔액스=");
		System.out.println(myAcorn-price);
		if(myAcorn-price<0) {//잔액부족
			cnt = -1;			
		}
		else if(cnt==2) {
			//걍넘기기
		}else {
			//잔액차감
			int useCnt = memberDao.useAcorn(userid, price);
			//order table 에추가
			if(useCnt==1) {
				OrderVO orderVo = new OrderVO();				
				String setterId = introVo.getUserid();
				cnt = orderDao.orderContent(setterId, userid, price);
			}
		}
		System.out.println("cnt="+cnt);
		req.setAttribute("cnt", cnt);
		req.setAttribute("introNo", introNo);
		
		return "buyOk.jsp";
	}

}
