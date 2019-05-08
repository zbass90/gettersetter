package gs.goott.myProfile.command;

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
import gs.goott.signup.MemberDAO;
import gs.goott.signup.MemberVO;

public class CommandmyProfileOk implements CommandService {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String data = null;
		String type = null;
		if(req.getParameter("pwchange")!=null){
			data = req.getParameter("pwchange"); 
			type = "userpwd";
		}else if(req.getParameter("telchange")!=null){
			data = req.getParameter("telchange"); 
			type = "tel";
		}else if(req.getParameter("emailchange")!=null){
			data = req.getParameter("emailchange"); 
			type = "email";
		}else if(req.getParameter("interestchange")!=null){
			String[] interest = req.getParameterValues("interest");
			data ="";
			for(int i=0; i<interest.length; i++) {
				data += interest[i]+"/";
				System.out.println("interestStr="+data);
			}
			type = "interest";
		}else{ // 프로필 파일 변경
			String path="\\\\GOOTT-1-13-PC\\gettersetter\\Users\\Thumbnails";
			//String path= req.getServletContext().getRealPath("/profileImage"); //톰캣의 절대경로로 파일을 저장.
			//톰캣 절대경로=> D:\workspaceWeb\.metadata\.plugins\org.eclipse.wst.server.core\tmp2\wtpwebapps\gettersetter\profileImage
			System.out.println("path="+path);
			int Max_size = 1024*1024*20; //20mb로 제한
			DefaultFileRenamePolicy pol = new DefaultFileRenamePolicy();
			MultipartRequest mr = new MultipartRequest(req,path,Max_size,"UTF-8",pol);
			String fileName = "";
			Enumeration fileList = mr.getFileNames();
			String oldfile = (String)fileList.nextElement();
			fileName = mr.getFilesystemName(oldfile); 
			
			type = "userImage";
			File file =new File(path+"/"+fileName);
			long length = file.length();
			byte[] imageByte = new byte[(int)length];
			try {
				
				FileInputStream fis = new FileInputStream(file);
				fis.read(imageByte);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			byte[] imageBase64 = Base64.encodeBase64(imageByte);
			String userimage = new String(imageBase64);
			System.out.println(userimage);
			data = userimage;
			
			
		};
		String userid = (String)req.getSession().getAttribute("userid");
		//String userid = "hahaori";
		MemberDAO dao = new MemberDAO();
		dao.profileUpdate(userid, data, type); //프로필 수정 !
		MemberVO vo = dao.getUserInfo(userid);
		req.setAttribute("vo", vo); 
		return "myProfile.jsp";
		
	}

}
