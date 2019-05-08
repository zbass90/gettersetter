package gs.goott.myProfile.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gs.goott.controller.CommandService;
import gs.goott.signup.MemberDAO;

public class CommandmyProfileDeleteOk implements CommandService {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String userid =(String)req.getSession().getAttribute("userid");
		MemberDAO dao = new MemberDAO();
		int cnt =dao.profileDelete(userid);
		req.setAttribute("cnt", cnt);
		if(cnt>0){
		req.getSession().removeAttribute("userid");
		
		req.getSession().setAttribute("loginStatus", 0);
		}
		return "deleteOk.jsp";
	}

}
