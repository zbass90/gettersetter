package gs.goott.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface CommandService {
	// view���ϸ��� �����Ѵ�.
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException;
}
