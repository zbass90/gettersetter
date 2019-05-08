package gs.goott.intro.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import gs.goott.content.ContentDAO;
import gs.goott.controller.CommandService;
import gs.goott.intro.IntroDAO;
import gs.goott.intro.IntroVO;
import gs.goott.signup.MemberDAO;
import gs.goott.signup.MemberVO;

public class CommandUpload implements CommandService {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		HttpSession ses = req.getSession();
		String userid = (String)ses.getAttribute("userid");
		IntroDAO introDAO = new IntroDAO();
		IntroVO introVO = introDAO.selectIntroVO(userid);
		
		ContentDAO contentDAO = new ContentDAO();
		System.out.println(introVO.getInterest().length);
		int interLength = introVO.getInterest().length;
		req.setAttribute("introVO", introVO);
		req.setAttribute("interLength", interLength);
		
		MemberDAO dao = new MemberDAO();
		MemberVO vo = dao.getUserInfo(userid);
		req.setAttribute("vo",vo);
		return "upload.jsp";
	}

}
