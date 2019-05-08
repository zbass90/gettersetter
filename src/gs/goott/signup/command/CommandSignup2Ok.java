package gs.goott.signup.command;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.codec.binary.Base64;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import gs.goott.controller.CommandService;
import gs.goott.intro.IntroDAO;
import gs.goott.signup.MemberDAO;
import gs.goott.signup.MemberVO;


public class CommandSignup2Ok implements CommandService {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//ȸ������
		req.setCharacterEncoding("UTF-8");

		//��Ƽ��Ʈ������Ʈ
		String path = "\\\\GOOTT-1-13-PC\\gettersetter\\Users\\Thumbnails";
		//String path= req.getServletContext().getRealPath("/profileImage"); //��Ĺ�� �����η� ������ ����.
		//��Ĺ ������=> D:\workspaceWeb\.metadata\.plugins\org.eclipse.wst.server.core\tmp2\wtpwebapps\gettersetter\profileImage
		System.out.println("path="+path);
		int Max_size = 1024*1024*20; //20mb�� ����
		DefaultFileRenamePolicy pol = new DefaultFileRenamePolicy();
		MultipartRequest mr = new MultipartRequest(req,path,Max_size,"UTF-8",pol);
		MemberVO vo =  (MemberVO)req.getSession().getAttribute("vo"); //id pwd email tel ����
		String fileName = "";
		Enumeration fileList = mr.getFileNames();
		String oldfile = (String)fileList.nextElement();
		fileName = mr.getFilesystemName(oldfile);
		File file = new File(path+"/"+fileName);
		long length = file.length();
		byte[] imageByte = new byte[(int)length];
		try {
			FileInputStream fis = new FileInputStream(file);
			fis.read(imageByte);
		}catch(Exception e) {
			e.printStackTrace();
		}
		byte[] imageBase64 = Base64.encodeBase64(imageByte);
		String userimage = new String(imageBase64);
		
		vo.setUserImage(userimage);
		System.out.println("�̹�������=" + userimage);
		vo.setInterest(mr.getParameterValues("interest"));
		
		MemberDAO dao = new MemberDAO();
		int cnt = dao.signup(vo);
		
		IntroDAO introDao =new IntroDAO();
		introDao.introInsert(vo.getUserid());
		/*String msg = "";
		String url = "";
		if(cnt > 0){
			msg = "���� ����";
			url = "<%=request.getContextPath()%>/index.do";
		}else {
			msg = "���� ����";
			url = "<%=request.getContextPath()%>/index.do";
		}
		req.setAttribute("msg", msg);
		req.setAttribute("url", url); �̷������� ������ �ѱ�� �ĵ� ����.*/
		//req.getSession().setAttribute("vo", vo);���ǿ� �־�ΰ� ���� ȸ�����Խ��� �̹��������� �����ȴ�.
		req.setAttribute("cnt", cnt);
		return "signup2.jsp";   //�ٽ�signup2.jsp�� ������ ��������.
	}
}