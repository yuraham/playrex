package yr.meetingdata;

import java.io.*;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import java.util.Date;

import playconnection.RexConnection;

public class MeetingDataDao  extends RexConnection{
	
	public int insertFile(HttpServletRequest request) {
		int maxSize = 10*1024*1024;
		String root = request.getSession().getServletContext().getRealPath("/");
		String savePath = root+"upload";
		String uploadFile="";
		String newFileName="";
		
		int read=0;
		byte[] buf=new byte[1024];
		FileInputStream fin = null;
		FileOutputStream fout = null;
		long currentTime = System.currentTimeMillis();
		SimpleDateFormat simDf = new SimpleDateFormat("yyyyMMddHHmmss");
		int res=0;
		try {
			MultipartRequest multi = new MultipartRequest(request, savePath, maxSize, "utf-8", new DefaultFileRenamePolicy());
			//파일업로드
			uploadFile = multi.getFilesystemName("fileName");
			//저장할 파일명(ex:20181114150911.jpg)
			newFileName = simDf.format(new Date(currentTime)) +"."+ uploadFile.substring(uploadFile.lastIndexOf(".")+1);
			//업로드된 파일 객체 생성
			File oldFile = new File(savePath + uploadFile);
			//실제 저장될 파일 객체 생성
			File newFile = new File(savePath + newFileName);
			//파일명 rename
			if(!oldFile.renameTo(newFile)){
				//rename이 되지 않을 경우 강제로 파일을 복사하고 기존파일은 삭제
				//buf = new byte[1024];
				////파일 낫파운드!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!1
				fin = new FileInputStream(oldFile);
				fout = new FileOutputStream(newFile);
				read = 0;
				while((read=fin.read(buf,0,buf.length))!=-1) {
					fout.write(buf,0,read);
				}
				fin.close();
				fout.close();
				oldFile.delete();
				res=1;
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return res;
	}
}
