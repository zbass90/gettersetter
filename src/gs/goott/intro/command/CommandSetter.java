package gs.goott.intro.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gs.goott.controller.CommandService;
import gs.goott.signup.MemberDAO;
import gs.goott.signup.MemberVO;

public class CommandSetter implements CommandService {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String userid = (String)req.getSession().getAttribute("userid");
		MemberDAO dao = new MemberDAO();
		MemberVO vo = dao.getUserInfo(userid);
		req.setAttribute("vo",vo);
		return "setter.jsp";
	}

}
