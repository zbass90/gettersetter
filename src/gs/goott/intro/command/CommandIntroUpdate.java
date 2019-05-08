package gs.goott.intro.command;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.codec.binary.Base64;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.sun.media.sound.FFT;

import gs.goott.controller.CommandService;
import gs.goott.intro.IntroDAO;
import gs.goott.intro.IntroVO;

public class CommandIntroUpdate implements CommandService {
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String path = "\\\\GOOTT-1-13-PC\\gettersetter\\Introduction";
		int maxSize = 1024*1024*1024;
		System.out.println(path);
		DefaultFileRenamePolicy pol = new DefaultFileRenamePolicy();
		MultipartRequest mr = new MultipartRequest(req, path, maxSize, "UTF-8", pol);		
		IntroVO vo = new IntroVO();
		
		HttpSession session = req.getSession(); //세션은 req로 해도 받아오네...
		//System.out.println("userid="+(String)session.getAttribute("userid"));
		vo.setUserid((String)session.getAttribute("userid"));		
		
		vo.setInterest(mr.getParameterValues("interest"));
		vo.setDescription(mr.getParameter("description"));		
		vo.setTitle(mr.getParameter("title"));		
		vo.setBeforeFileName(mr.getParameter("beforeFileName"));
		vo.setBeforeThumbnail(mr.getParameter("beforeThumbnail"));
		
		String fileName = "";
		String thumbnailFilename ="";
		Enumeration fileList = mr.getFileNames();
		while(fileList.hasMoreElements()) {
			String oldFile = (String)fileList.nextElement();
			System.out.println("oldFile="+oldFile);   //oldFile=filename  or  oldFile=thumbnail
			if(oldFile.equals("filename")) {
				fileName = mr.getFilesystemName(oldFile);
			}else if(oldFile.equals("thumbnail")) {
				thumbnailFilename = mr.getFilesystemName(oldFile);
			}
			
		}
		
		vo.setFilename(fileName);
		System.out.println("filename="+fileName);  //첨부안하면 null 나옴
		System.out.println("thumbnailFilename="+thumbnailFilename);
		vo.setThumbnailFileName(thumbnailFilename);
		///////////////////////////////////thmbnail
		//fileName 이 이미지형식일경우에만
		if(!thumbnailFilename.equals("") && thumbnailFilename !=null) {
			//이미업로드가됬기떄문에 파일이 폴더안에존재함
			File file = new File(path+"/"+thumbnailFilename);
			long length = file.length();
			System.out.println("file length="+length);
			//파일의 크기만한 배열을만든다
			byte[] thumbnailByte = new byte[(int)length];
			
			try {
				FileInputStream fis = new FileInputStream(file);
				//바이트 배열의 크기만큼 읽어서 바이트배열에 때려넣는다 
				fis.read(thumbnailByte);
				System.out.println("byte array="+thumbnailByte);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			byte[] thumbnailBase64 = Base64.encodeBase64(thumbnailByte);
			System.out.println("thumbnailBase64="+thumbnailBase64);
			//base64 인코딩된 이름
			String thumbnail = new String(thumbnailBase64);
			System.out.println("thumbnail="+thumbnail.substring(0,10));
			vo.setThumbnail(thumbnail);
		}
		////////////////////////////////////////////////////

		IntroDAO dao = new IntroDAO();
		int cnt = dao.introUpdate(vo,path);
		
		
		IntroVO vo2 = dao.selectIntroVO(vo.getUserid());		
		req.setAttribute("cnt", cnt);
		req.setAttribute("vo", vo2);		
		
		return "uploadOk.jsp";
	}

}
