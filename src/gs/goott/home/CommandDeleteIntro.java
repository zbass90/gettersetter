package gs.goott.home;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gs.goott.controller.CommandService;
import gs.goott.intro.IntroDAO;

public class CommandDeleteIntro implements CommandService {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int introNo = Integer.parseInt(req.getParameter("introNo"));
		IntroDAO dao = new IntroDAO();
		int cnt = dao.introDelete(introNo);
		
		req.setAttribute("cnt", cnt);
		return "managerDeleteOk.jsp";
	}

}
