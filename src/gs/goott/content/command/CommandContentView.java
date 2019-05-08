package gs.goott.content.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gs.goott.content.ContentDAO;
import gs.goott.content.ContentVO;
import gs.goott.controller.CommandService;

public class CommandContentView implements CommandService {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String userid = req.getParameter("userid");
		int contentNo = Integer.parseInt(req.getParameter("contentNo"));
		String interest = req.getParameter("interest");		
		
		ContentDAO contentDAO = new ContentDAO();
		contentDAO.viewCount(contentNo);
		ContentVO contentVO = new ContentVO();
		contentVO = contentDAO.getContent(userid, contentNo);
		
		List<ContentVO> interestList = contentDAO.getInterestList(userid, interest, contentNo);
		
		
		req.setAttribute("contentVO", contentVO);
		req.setAttribute("interestList", interestList);
		return "contentView.jsp";
	}

}
