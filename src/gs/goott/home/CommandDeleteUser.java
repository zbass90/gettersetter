package gs.goott.home;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gs.goott.controller.CommandService;
import gs.goott.signup.MemberDAO;

public class CommandDeleteUser implements CommandService {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		MemberDAO dao = new MemberDAO();
		String userid = req.getParameter("userid");		
		dao.profileDelete(userid);
		return "managerDeleteOk.jsp";
	}

}
