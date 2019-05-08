package gs.goott.signup.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gs.goott.controller.CommandService;

public class CommandSignup implements CommandService {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//메인에서 회원가입누르면 회원가입 페이지로./signup/signup.do=gs.goott.signup.command.CommandSignup
		return "signup.jsp";
	}

}
