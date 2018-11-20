package sk.picture.action;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import member.controller.CommandAction;
import sk.picture.PictureDao;

public class InsertPictureAction implements CommandAction {
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		String savePath = request.getServletContext().getRealPath("imgFile");
		// 파일이 저장될 서버의 경로 //getRealPath는 서버상에서 webapps 까지의 경로
		int sizeLimit = 1024*1024*15; // 파일 크기 15MB로 제한

		PictureDao data = new PictureDao();
		MultipartRequest multi = new MultipartRequest(request, savePath, sizeLimit, "utf-8", new DefaultFileRenamePolicy());
		ByteArrayOutputStream bout = new ByteArrayOutputStream(); 
		File file = null;
		FileInputStream in = null;
    	int len = 0;
		
    	
    	Enumeration<String> forms = multi.getFileNames();
		while(forms.hasMoreElements()) {
			String formName = (String)forms.nextElement();
			String fileName = multi.getFilesystemName(formName);
//			String testFileFullpath = savePath+"/"+ fileName; //파일 전체경로
			if(fileName != null) {
				file = multi.getFile(formName); //파일객체 생성
				try {
					in = new FileInputStream(file); //바이너리로 변환
					byte[] bt = new byte[(int)file.length()]; //file.length는 파일으 크기
					while((len=in.read(bt)) != -1) { // read()는 파일의 내용을 바이트 단위로 읽어드린후 정수로 반환한다.
						// 파일을 읽어들여 -1이 아닐때 반복된다.
						bout.write(bt, 0, len); // 바이트배열 저장소에 쓴다. write(대상에,데이터의 시작 오프셋부터,저장될 바이트의 길이만큼 쓴다)
						}
					
					byte[] file_byte = bout.toByteArray(); //스트림을 Byte 배열 형태로 변환
					
					data.insertFile(file_byte, 8, fileName, file.length() );
//					data.insertFile(파일, 파일저장소, 사원버호, 파일 이름, 파일크기 );
					
					bout.close();
					in.close();
					file.delete();
				} catch (Exception e) {
					e.printStackTrace();
				} 
			}
			
		}
//		String fileName = multi.getFilesystemName("test-img");//파일이름
//		String testFileFullpath = savePath+"/"+ fileName; //파일 전체경로
		
		
		
		
		
		
		
		
		
		
		
		
		return null;
	}

}
