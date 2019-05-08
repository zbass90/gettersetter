package gs.goott.home;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gs.goott.controller.CommandService;
import gs.goott.intro.IntroDAO;
import gs.goott.intro.IntroVO;
import gs.goott.signup.MemberDAO;
import gs.goott.signup.MemberVO;

public class CommandManager implements CommandService {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		IntroDAO introdao = new IntroDAO();
		MemberDAO memberdao = new MemberDAO();
		
		IntroVO introvo = new IntroVO();
		MemberVO membervo = new MemberVO();
		
		List<MemberVO> memberList  = memberdao.getAllUser();
		List<IntroVO> introList  = introdao.getAllIntro();
		
		System.out.println("memberList"+memberList.size());
		System.out.println("introList"+introList.size());
		
		req.setAttribute("memberList", memberList);
		req.setAttribute("introList", introList);
		
		
		return "manager.jsp";
	}

}
