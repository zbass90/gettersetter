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
		//ȸ������1������ ���� ������� �޴� ������, 2�������� �Ѿ��. signup->CommandsignupOk
		req.setCharacterEncoding("UTF-8");
		MemberVO vo = new MemberVO();
		vo.setUserid(req.getParameter("userid"));
		vo.setUserpwd(req.getParameter("userpwd"));
		vo.setTel(req.getParameter("tel"));
		vo.setEmail(req.getParameter("email"));
		
		
		req.getSession().setAttribute("vo", vo); //������ ���ǿ� �־�α�
		MemberDAO dao = new MemberDAO();
		int cnt = dao.idCheck(req.getParameter("userid")); //signup ȭ���� ���̵�üũ
		req.setAttribute("cnt", cnt);
		return "signupOk.jsp";   //������, ���� signup2.jsp�� ��������
	}
}