package gs.goott.signup.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gs.goott.controller.CommandService;

public class CommandSignup implements CommandService {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//���ο��� ȸ�����Դ����� ȸ������ ��������./signup/signup.do=gs.goott.signup.command.CommandSignup
		return "signup.jsp";
	}

}
