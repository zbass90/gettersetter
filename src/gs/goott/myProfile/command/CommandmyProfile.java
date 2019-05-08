package gs.goott.myProfile.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import gs.goott.content.ContentDAO;
import gs.goott.content.ContentVO;
import gs.goott.controller.CommandService;

import gs.goott.intro.IntroDAO;
import gs.goott.intro.IntroVO;
import gs.goott.intro.OrderDAO;
import gs.goott.intro.OrderVO;

import gs.goott.signup.MemberDAO;
import gs.goott.signup.MemberVO;

public class CommandmyProfile implements CommandService {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String userid = (String)req.getSession().getAttribute("userid");
		// 로그인 시 세션에 id 저장해놓은 값 
		MemberDAO dao = new MemberDAO();
		MemberVO vo = dao.getUserInfo(userid);
		req.setAttribute("vo",vo);
		
		//과거에 봤던 introNo들
		List<IntroVO> list = (List<IntroVO>)session.getAttribute("history");
		req.setAttribute("historyList", list);
		
		OrderDAO dao1 = new OrderDAO();
		List<IntroVO> list1 = dao1.orderList(userid);
		req.setAttribute("orderlist", list1);
		
		
		
		return "myProfile.jsp";
	}

}
