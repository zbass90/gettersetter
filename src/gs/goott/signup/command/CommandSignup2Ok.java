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
		//회원가입
		req.setCharacterEncoding("UTF-8");

		//멀티파트리퀘스트
		String path = "\\\\GOOTT-1-13-PC\\gettersetter\\Users\\Thumbnails";
		//String path= req.getServletContext().getRealPath("/profileImage"); //톰캣의 절대경로로 파일을 저장.
		//톰캣 절대경로=> D:\workspaceWeb\.metadata\.plugins\org.eclipse.wst.server.core\tmp2\wtpwebapps\gettersetter\profileImage
		System.out.println("path="+path);
		int Max_size = 1024*1024*20; //20mb로 제한
		DefaultFileRenamePolicy pol = new DefaultFileRenamePolicy();
		MultipartRequest mr = new MultipartRequest(req,path,Max_size,"UTF-8",pol);
		MemberVO vo =  (MemberVO)req.getSession().getAttribute("vo"); //id pwd email tel 정보
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
		System.out.println("이미지네임=" + userimage);
		vo.setInterest(mr.getParameterValues("interest"));
		
		MemberDAO dao = new MemberDAO();
		int cnt = dao.signup(vo);
		
		IntroDAO introDao =new IntroDAO();
		introDao.introInsert(vo.getUserid());
		/*String msg = "";
		String url = "";
		if(cnt > 0){
			msg = "가입 성공";
			url = "<%=request.getContextPath()%>/index.do";
		}else {
			msg = "가입 실패";
			url = "<%=request.getContextPath()%>/index.do";
		}
		req.setAttribute("msg", msg);
		req.setAttribute("url", url); 이런식으로 데이터 넘기는 식도 있음.*/
		//req.getSession().setAttribute("vo", vo);세션에 넣어두고 쓰면 회원가입시의 이미지정보로 고정된다.
		req.setAttribute("cnt", cnt);
		return "signup2.jsp";   //다시signup2.jsp로 데이터 데려가기.
	}
}