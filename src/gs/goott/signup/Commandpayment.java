package gs.goott.signup;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import gs.goott.controller.CommandService;

public class Commandpayment implements CommandService {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		String userid = (String)req.getSession().getAttribute("userid");
		MemberDAO dao1 = new MemberDAO();
		MemberVO vo = dao1.getUserInfo(userid);
		req.setAttribute("vo",vo);

		
		HttpSession session = req.getSession();

		return "payment.jsp";
	}

}
