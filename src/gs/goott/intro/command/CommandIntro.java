package gs.goott.intro.command;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import gs.goott.content.ContentDAO;
import gs.goott.content.ContentVO;
import gs.goott.controller.CommandService;
import gs.goott.intro.IntroDAO;
import gs.goott.intro.IntroVO;
import gs.goott.intro.OrderDAO;
import gs.goott.intro.replyDAO;
import gs.goott.intro.replyVO;
import gs.goott.signup.MemberDAO;
import gs.goott.signup.MemberVO;

public class CommandIntro implements CommandService {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
	
		
		int introNo = Integer.parseInt(req.getParameter("introNo"));
		System.out.println("introNo="+introNo);
		IntroVO vo = new IntroVO();
		IntroDAO dao =new IntroDAO();
		vo = dao.getIntro(introNo);
		req.setAttribute("introVO", vo); //membervo �� ��ĥ����� �־� introVO �� �̸��� ����	
		
		String userid = vo.getUserid();	//content �ڷ� �ҷ�����!
		ContentDAO dao2 = new ContentDAO();
		List<ContentVO> cList = dao2.getContentList(userid);
		req.setAttribute("cList", cList);
		
		System.out.println("VO="+vo.getUserid());	
	
		replyDAO replyDao = new replyDAO();
		List<replyVO> list = replyDao.getReply(introNo);
		int listSize= list.size();
		req.setAttribute("list", list);
		req.setAttribute("listSize", listSize);
		
		//����� ������ ������Ʈ�ϱ� ���� �ٽ� ���Ǽ���
		MemberVO memberVo = new MemberVO();
		MemberDAO memberDao = new MemberDAO();
			//�α������������̵�
			String loginUserid = (String)session.getAttribute("userid");
		memberVo = memberDao.getUserInfo(loginUserid);
		session.setAttribute("vo", memberVo);
		
		//intro ���� (������ڴ������ �ۼ�Ʈ)
		IntroVO starRateVO = dao.starRate(introNo);
		req.setAttribute("starRateVO", starRateVO);
		//���������ʿ��� history ������ session �� �ش� introno �迭 �߰�
		
		List<IntroVO> history = new ArrayList<IntroVO>();
		//int[] history = new int[10];
		
		System.out.println("session history="+session.getAttribute("history"));
		if(session.getAttribute("history")!=null) {
			List<IntroVO> historyList = (List<IntroVO>) session.getAttribute("history");
			for(int i=0;i<historyList.size();i++) {
				//System.out.println("historylist="+historyList.get(i));				
				history.add(historyList.get(i));
			}
		}else if(session.getAttribute("history")==null){
			history.add(dao.getIntro(introNo));
		}
		int condition =0;
		for(int i=0;i<history.size();i++) {  
			if((history.get(i).getIntroNo() == introNo)) {  //�ߺ� �̸� �߰����� ��
				System.out.println(history.get(i).getIntroNo());  //�ϳ��� ������ �߰� ����
				System.out.println(" ==? "+introNo);
				condition = 1;  //1�̸� �ߺ������� �߰�				
			}
		}
		if(condition==0) {  //0 �� history �� �ߺ� ����
			history.add(dao.getIntro(introNo));
		}	
		session.setAttribute("history", history); 
		for(int i=0;i<history.size();i++) {
			System.out.println("history="+history.get(i));
		}
		OrderDAO orderDAO = new OrderDAO();
		int cnt = orderDAO.orderCheck(userid, (String)session.getAttribute("userid"));
		req.setAttribute("cnt", cnt);
		return "intro.jsp";
	}

}
