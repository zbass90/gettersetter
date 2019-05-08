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
		System.out.println("init�����");//Mapping
		//properties�� UrlMapping.properties������ �����ϱ�
		String propertiesFilename = config.getInitParameter("proConfig");
		Properties pro = new Properties();
		try {
			FileInputStream fis = new FileInputStream(propertiesFilename);
			pro.load(fis);
		}catch(Exception e) {
			System.out.println("init�޼ҵ� - properties");
			System.out.println(e.getMessage());
		}
		
		try {
			//properties�� �ִ� ���ڿ���  HashMap�� �����Ѵ�.
			Set keyList = pro.keySet();
			Iterator keyIterator = keyList.iterator();
			while(keyIterator.hasNext()) {//key�� ������
				String key = (String)keyIterator.next();
				//						kr.goott.home.CommandIndex
				String className = pro.getProperty(key); //�ش� Ű�� Ŭ������ �ش��ϴ� ���ڿ�
				System.out.println(key+"="+className);
				//���ڿ��� ��ü�� �����
				Class commandClass = Class.forName(className);
				//��ü�� ������ Ŭ������ CommandService�� ����ȯ�Ͽ� HashMap�� ����
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
		//����ȭ�� ��.do �ؾ��� /*.do, /index.do, /freeboard/list.do...
		String uri = req.getRequestURI();
		System.out.println("uri="+uri);
		String contextPath = req.getContextPath();
		System.out.println("contextPath="+contextPath);
		String commandKey = uri.substring(contextPath.length()); // /*.do
		System.out.println(commandKey);
		CommandService service = mapping.get(commandKey);
		String viewFile = service.process(req, res);
		
	
		//view ���Ϸ� ������ �̵��ϱ�
		RequestDispatcher dispatcher = req.getRequestDispatcher(viewFile);
		dispatcher.forward(req, res);
	}
}
