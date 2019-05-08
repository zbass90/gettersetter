package gs.goott.intro.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gs.goott.controller.CommandService;
import gs.goott.intro.IntroDAO;
import gs.goott.intro.replyDAO;

public class CommandReplyWrite implements CommandService {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String commentContent = req.getParameter("commentContent");
		Double star = Double.parseDouble(req.getParameter("star"));
		String contentid = req.getParameter("contentid");
		String commenter = req.getParameter("commenter");
		int introNo = Integer.parseInt(req.getParameter("introNo"));
		
		replyDAO dao = new replyDAO();
		IntroDAO introDAO = new IntroDAO();
		introDAO.totalStar(contentid, (int)Math.round(star));
		int cnt = dao.writeReply(commenter,commentContent, star,introNo);
		req.setAttribute("cnt", cnt);
		req.setAttribute("introNo", introNo);
		
		System.out.println(cnt);
		return "introOk.jsp";
	}

}
