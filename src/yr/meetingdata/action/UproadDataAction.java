//package yr.meetingdata.action;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import com.oreilly.servlet.MultipartRequest;
//import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
//
//import member.controller.CommandAction;
//
//public class UproadDataAction implements CommandAction{
//	@Override
//	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
//		request.setCharacterEncoding("utf-8");
//		
//		MultipartRequest multi = null;
//		int sizeLimit = 10*1024*1024;
//		String uploadPath = request.getRealPath("/upload");
//		
//		try { 
//			multi=new MultipartRequest(request, savePath, sizeLimit, "UTF-8", new DefaultFileRenamePolicy());
//		} catch(Exception e) {
//			e.printStackTrace();
//		}
//		
//		String filename = multi.getFilesystemName("filename");
//		String 
//	}
//}
