package gs.goott.signup.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import gs.goott.controller.CommandService;

public class CommandLogout implements CommandService {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session = req.getSession();
		//System.out.println((String)session.getAttribute("loginStatus"));
		session.setAttribute("userid", null);
		session.setAttribute("loginStatus", null);
		session.setAttribute("history", null);
		
		return "logout.jsp";
	}

}
