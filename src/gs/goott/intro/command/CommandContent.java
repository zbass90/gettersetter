package gs.goott.intro.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gs.goott.controller.CommandService;
import gs.goott.intro.IntroDAO;
import gs.goott.intro.IntroVO;

public class CommandContent implements CommandService {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		IntroDAO dao = new IntroDAO();
		String interest = req.getParameter("interest");
		String search = req.getParameter("search");
		if(interest==null) {
			interest="";
		}
		if(search==null) {
			search="";
		}
		List<IntroVO> list = dao.getContent(interest.toLowerCase(),search);
		req.setAttribute("list", list);
		req.setAttribute("interest", interest);
		return "content.jsp";
	}

}
