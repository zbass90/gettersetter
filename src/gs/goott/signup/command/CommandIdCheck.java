package gs.goott.signup.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gs.goott.controller.CommandService;
import gs.goott.signup.MemberDAO;

public class CommandIdCheck implements CommandService {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String userid = req.getParameter("userid");
		System.out.println("아아아아"+userid);
		MemberDAO dao = new MemberDAO();
		int cnt = dao.idCheck(userid);
		
		req.setAttribute("cnt", cnt); // idCheck.jsp에서 사용가능한 데이터가된다.
		req.setAttribute("userid", userid);
		return "idCheck.jsp";
	}

}
