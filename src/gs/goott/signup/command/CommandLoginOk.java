package gs.goott.signup.command;

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import gs.goott.content.ContentDAO;
import gs.goott.content.ContentVO;
import gs.goott.controller.CommandService;
import gs.goott.signup.MemberDAO;
import gs.goott.signup.MemberVO;

public class CommandLoginOk implements CommandService {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String userid = req.getParameter("userid");
		String userpwd = req.getParameter("userpwd");
		System.out.println("userid="+userid);
		MemberDAO dao = new MemberDAO();
		MemberVO vo = new MemberVO();
		ContentDAO condao = new ContentDAO();
		ContentVO convo = new ContentVO();
		//로그인
		int cnt = dao.loginCheck(userid,userpwd);
		//로그인정보 흩뿌리기
		System.out.println("cnt="+cnt);
		if(cnt==1) {
			vo = dao.getUserInfo(userid);
			req.setAttribute("cnt", cnt);
			req.setAttribute("vo", vo);
			
			//로그인상태 세션 0-미로그인 1-로그인
			HttpSession session = req.getSession();
			session.setAttribute("loginStatus", 1);
			//로그인 아이디 세션
			session.setAttribute("userid", vo.getUserid());
			session.setAttribute("vo",vo);
			//컨텐츠 정보 세션
			
			/*List<ContentVO>conlist =condao.getContentList(userid);
			req.setAttribute("conlist", conlist);
			session.setAttribute("conlist", conlist);
			System.out.println("리스트리스트리스트리스트리스트리스트리스트리스트"+conlist);*/
			
			
		}
		return "loginOk.jsp";

	}

}
