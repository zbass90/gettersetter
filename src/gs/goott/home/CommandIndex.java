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

		////////인덱스페이지에서 우측상단에 이미지 파일 불러오기 위해.${mem.userImage}
		String userid = (String)req.getSession().getAttribute("userid");
		MemberDAO dao1 = new MemberDAO();
		MemberVO vo = dao1.getUserInfo(userid);
		req.setAttribute("vo",vo);
		System.out.println("level="+vo.getUserLevel());
		/////////////////////////////////////

		//6개의 가장핫한세터추천
		IntroDAO dao = new IntroDAO();
		
		List<IntroVO> list = new ArrayList<IntroVO>();
		 if(session.getAttribute("loginStatus")==null) {
			 System.out.println("로그인안된상태"); 
			 list = dao.getRecommendContents("none");
			 
		 }else{ 			 
			 System.out.println("로그인된상태"); 
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
