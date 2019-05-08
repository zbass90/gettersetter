package gs.goott.signup;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import gs.goott.controller.CommandService;

public class CommandpaymentOk implements CommandService {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// ���丮 ���� ���
		HttpSession session = req.getSession();
		MemberVO vo = new MemberVO();
		String userid = (String)session.getAttribute("userid");
		System.out.println("userid="+userid);
		//�����Ϸ��� acorn ��
		int buyAcorn = Integer.parseInt(req.getParameter("buyAcorn"));
		System.out.println("buyacorn="+buyAcorn);
		MemberDAO dao = new MemberDAO();
		//vo���� �ҷ�����
		vo = dao.getUserInfo(userid);
		System.out.println("MY ACORN="+vo.getMyAcorn());
		//id, ���ż�(buyacorn), myacorn
		int cnt = dao.buyAcorn(userid, buyAcorn,vo.getMyAcorn());
		req.setAttribute("cnt",cnt);
		req.setAttribute("userid",vo.getUserid());
		req.setAttribute("myAcorn",vo.getMyAcorn());
		
		//�α�������
		
		int loginStatus = (int)session.getAttribute("loginStatus");
		req.setAttribute("loginStatus",loginStatus);
		return "paymentOk.jsp";
	}

}
