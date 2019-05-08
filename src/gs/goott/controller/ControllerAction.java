package gs.goott.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/*.do")
public class ControllerAction extends HttpServlet {
	
	HashMap<String, CommandService> mapping = new HashMap<String, CommandService>();
	
    public ControllerAction() {
        super();
    }
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init실행됨");//Mapping
		//properties에 UrlMapping.properties데이터 셋팅하기
		String propertiesFilename = config.getInitParameter("proConfig");
		Properties pro = new Properties();
		try {
			FileInputStream fis = new FileInputStream(propertiesFilename);
			pro.load(fis);
		}catch(Exception e) {
			System.out.println("init메소드 - properties");
			System.out.println(e.getMessage());
		}
		
		try {
			//properties에 있는 문자열을  HashMap에 저장한다.
			Set keyList = pro.keySet();
			Iterator keyIterator = keyList.iterator();
			while(keyIterator.hasNext()) {//key가 있으면
				String key = (String)keyIterator.next();
				//						kr.goott.home.CommandIndex
				String className = pro.getProperty(key); //해당 키의 클래스명에 해당하는 문자열
				System.out.println(key+"="+className);
				//문자열을 객체로 만들기
				Class commandClass = Class.forName(className);
				//객체로 생성된 클래스를 CommandService로 형변환하여 HashMap에 셋팅
				CommandService command = (CommandService)commandClass.getDeclaredConstructors()[0].newInstance();
				mapping.put(key, command);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		mvcStart(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		mvcStart(request, response);
	}
	protected void mvcStart(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//접속화면 단.do 해야함 /*.do, /index.do, /freeboard/list.do...
		String uri = req.getRequestURI();
		System.out.println("uri="+uri);
		String contextPath = req.getContextPath();
		System.out.println("contextPath="+contextPath);
		String commandKey = uri.substring(contextPath.length()); // /*.do
		System.out.println(commandKey);
		CommandService service = mapping.get(commandKey);
		String viewFile = service.process(req, res);
		
	
		//view 파일로 페이지 이동하기
		RequestDispatcher dispatcher = req.getRequestDispatcher(viewFile);
		dispatcher.forward(req, res);
	}
}
