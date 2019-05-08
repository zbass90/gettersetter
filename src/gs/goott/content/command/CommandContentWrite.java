package gs.goott.content.command;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.codec.binary.Base64;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import gs.goott.content.ContentDAO;
import gs.goott.content.ContentVO;
import gs.goott.controller.CommandService;

public class CommandContentWrite implements CommandService{
	String thumbnailPath;
	ContentVO vo;
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String path = "\\\\172.16.1.13\\gettersetter\\Content\\video";
		int maxSize = 1024*1024*1024;
		DefaultFileRenamePolicy pol = new DefaultFileRenamePolicy();
		MultipartRequest mr = new MultipartRequest(req,path,maxSize,"UTF-8",pol);
		
		/*HttpSession session = req.getSession(); 세션값으로 아이디 가져오기
		String userid = (String)session.getAttribute("userid");*/
		vo = new ContentVO();
		HttpSession session = req.getSession();
		vo.setUserid((String)session.getAttribute("userid"));
		vo.setTitle(mr.getParameter("title"));
		vo.setDescription(mr.getParameter("description"));
		vo.setInterest(mr.getParameter("interest"));
		
		String fileName = "";
		
		Enumeration fileList = mr.getFileNames();
		if(fileList.hasMoreElements()) {
			String oldFile = (String)fileList.nextElement();
			fileName =mr.getFilesystemName(oldFile);
		}
		vo.setFilename(fileName);		
		
		System.out.println(path);
		Calendar c = Calendar.getInstance();
		System.out.println(c.getTimeInMillis());
		Runtime run = Runtime.getRuntime();
		String ffmpegPath ="net use \\\\172.16.1.13\\gettersetter\\ffmpeg\\bin"; 
		String ffmpeg = "\\\\\\\\172.16.1.13\\\\gettersetter\\\\ffmpeg\\\\bin\\ffmpeg.exe";
		String ffprobe = "\\\\\\\\172.16.1.13\\\\gettersetter\\\\ffmpeg\\\\bin\\ffprobe.exe";
		String thumbnailName =fileName.substring(0, fileName.length()-4);
		thumbnailPath = "\\\\172.16.1.13\\gettersetter\\Content\\thumbnail\\"+vo.getInterest()+"\\"+thumbnailName+".png";
		String command =ffmpeg+" -i "+path+"\\"+fileName+" -ss 00:00:03 -vcodec png -vframes 1 "+thumbnailPath;
		String command2 = ffprobe+" -v error -show_entries format=duration -of default=noprint_wrappers=1:nokey=1 "+path+"\\"+fileName;
		String returnData =	"";
		try {
			run.exec("cmd.exe chcp 65001");
			run.exec(ffmpegPath);
			run.exec(command);
			Process p = Runtime.getRuntime().exec(command2);
			InputStream in = p.getInputStream();
			int i;
			while((i=in.read())!=-1) {
				returnData += (char)i;
			}
			vo.setVideoLength(Float.valueOf(String.format("%.2f", Float.valueOf(returnData)))); //영상길이 vo에 담기
			System.out.println("영상길이"+vo.getVideoLength());				
		}catch(Exception e) {
			System.out.println("탐색기 오픈 에러"+e.getMessage());
		}		
		Calendar c2 = Calendar.getInstance();
		System.out.println(c2.getTimeInMillis()-c.getTimeInMillis());
		
		while(true) {
			try {
				Thread.sleep(c2.getTimeInMillis()-c.getTimeInMillis()+100);
			}catch(Exception e) {
				System.out.println("스레드 에러"+e.getMessage());
			}
			File file = new File(thumbnailPath);
			if(file.exists()) {
				long length = file.length();
				byte[] thumbnailByte = new byte[(int)length];			
				try {
					FileInputStream fis = new FileInputStream(file);
					fis.read(thumbnailByte);		
					byte[] thumbnailBase64 = Base64.encodeBase64(thumbnailByte);
					String thumbnail = new String(thumbnailBase64);
					vo.setThumbnail(thumbnail);	//썸네일 vo에 담기	
					System.out.println(vo.getThumbnail());
				}catch(Exception e) {
					System.out.println("썸네일 파일 바인더 변환 에러"+e.getMessage());
				}
				break;
			}				
		}		
			
		ContentDAO dao = new ContentDAO();
		int cnt = dao.contentWrite(vo);
		
		
		return "upload.jsp";
	}
	
}
