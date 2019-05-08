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
		//�α���
		int cnt = dao.loginCheck(userid,userpwd);
		//�α������� ��Ѹ���
		System.out.println("cnt="+cnt);
		if(cnt==1) {
			vo = dao.getUserInfo(userid);
			req.setAttribute("cnt", cnt);
			req.setAttribute("vo", vo);
			
			//�α��λ��� ���� 0-�̷α��� 1-�α���
			HttpSession session = req.getSession();
			session.setAttribute("loginStatus", 1);
			//�α��� ���̵� ����
			session.setAttribute("userid", vo.getUserid());
			session.setAttribute("vo",vo);
			//������ ���� ����
			
			/*List<ContentVO>conlist =condao.getContentList(userid);
			req.setAttribute("conlist", conlist);
			session.setAttribute("conlist", conlist);
			System.out.println("����Ʈ����Ʈ����Ʈ����Ʈ����Ʈ����Ʈ����Ʈ����Ʈ"+conlist);*/
			
			
		}
		return "loginOk.jsp";

	}

}
