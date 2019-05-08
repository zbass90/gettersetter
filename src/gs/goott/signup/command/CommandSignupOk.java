package gs.goott.signup.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import gs.goott.controller.CommandService;
import gs.goott.signup.MemberDAO;
import gs.goott.signup.MemberVO;



public class CommandSignupOk implements CommandService {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//회원가입1페이지 에서 폼제출시 받는 데이터, 2페이지로 넘어간다. signup->CommandsignupOk
		req.setCharacterEncoding("UTF-8");
		MemberVO vo = new MemberVO();
		vo.setUserid(req.getParameter("userid"));
		vo.setUserpwd(req.getParameter("userpwd"));
		vo.setTel(req.getParameter("tel"));
		vo.setEmail(req.getParameter("email"));
		
		
		req.getSession().setAttribute("vo", vo); //데이터 세션에 넣어두기
		MemberDAO dao = new MemberDAO();
		int cnt = dao.idCheck(req.getParameter("userid")); //signup 화면의 아이디체크
		req.setAttribute("cnt", cnt);
		return "signupOk.jsp";   //데이터, 세션 signup2.jsp에 데려가기
	}
}