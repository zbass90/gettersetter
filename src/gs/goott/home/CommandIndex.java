package gs.goott.home;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import gs.goott.controller.CommandService;
import gs.goott.intro.IntroDAO;
import gs.goott.intro.IntroVO;
import gs.goott.signup.MemberDAO;
import gs.goott.signup.MemberVO;

public class CommandIndex implements CommandService {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session = req.getSession();


		//System.out.println("loginStatus="+session.getAttribute("loginStatus"));

		////////�ε������������� ������ܿ� �̹��� ���� �ҷ����� ����.${mem.userImage}
		String userid = (String)req.getSession().getAttribute("userid");
		MemberDAO dao1 = new MemberDAO();
		MemberVO vo = dao1.getUserInfo(userid);
		req.setAttribute("vo",vo);
		System.out.println("level="+vo.getUserLevel());
		/////////////////////////////////////

		//6���� �������Ѽ�����õ
		IntroDAO dao = new IntroDAO();
		
		List<IntroVO> list = new ArrayList<IntroVO>();
		 if(session.getAttribute("loginStatus")==null) {
			 System.out.println("�α��ξȵȻ���"); 
			 list = dao.getRecommendContents("none");
			 
		 }else{ 			 
			 System.out.println("�α��εȻ���"); 
			 System.out.println((String)session.getAttribute("userid"));
			 String interestStr = dao.getInterest((String)session.getAttribute("userid"));
			 System.out.println(interestStr);
			 list = dao.getRecommendContents(interestStr);
		 }
		 
		 req.setAttribute("list", list);
		System.out.println(list.size());
		
		return "index.jsp";
	}

}
