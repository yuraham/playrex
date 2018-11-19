package yr.meetingdata;

import java.io.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

import com.oreilly.servlet.MultipartRequest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import playconnection.RexConnection;

public class MeetingDataDao  extends RexConnection{
	
	//파일첨부
	public List<String> insertFile(MultipartRequest multi, String savePath, int mit_numb) {
		String uploadFile="";
		String newFileName="";
		String uFileRename="";
		List<String> list = new ArrayList<String>(); 
		int read=0;
		byte[] buf=new byte[1024];
		FileInputStream fin = null;
		FileOutputStream fout = null;
		long currentTime = System.currentTimeMillis();
		SimpleDateFormat simDf = new SimpleDateFormat("yyyyMMddHHmmss");
		try {
			//파일업로드
			if (multi.getFilesystemName("fileName") != null) {
				uploadFile = multi.getFilesystemName("fileName");
				uFileRename=uploadFile.substring(0, uploadFile.lastIndexOf("."));
				newFileName = simDf.format(new Date(currentTime))+"_"+uFileRename+"_"+mit_numb +"."+ uploadFile.substring(uploadFile.lastIndexOf(".")+1);
				File oldFile = new File(savePath + "\\" +uploadFile);
				File newFile = new File(savePath + "\\" +newFileName);
				if(!oldFile.renameTo(newFile)){
					fin = new FileInputStream(oldFile);
					fout = new FileOutputStream(newFile);
					read = 0;
					while((read=fin.read(buf,0,buf.length))!=-1) {
						fout.write(buf,0,read);
					}
					fin.close();
					fout.close();
					oldFile.delete();
				}
			}
			list.add(uploadFile);
			list.add(newFileName);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	//db넣기
	public int insertData(String fileName, String realName, int met_numb) {
		PreparedStatement pstmt = null;
		String query = "INSERT INTO rex_meetingData (data_numb, data_name, data_real_name, data_met)"
				+"VALUES (null,?,?,?)";
		int res=0;
		openConnection();
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, fileName);
			pstmt.setString(2, realName);
			pstmt.setInt(3, met_numb);
			res = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return res;
	}
	
	//다운로드
	public int downData(HttpServletRequest request, HttpServletResponse response, String savePath, String realFile, String dataName) {
		InputStream in = null;
		OutputStream os = null;
		File file = null;
		boolean skip = false;
		String client = "";
		int res=0;
		try {
			try {
				file = new File(savePath, realFile);
				in = new FileInputStream(file);
			}catch(FileNotFoundException e) {
				skip=true;
			}
			
			client = request.getHeader("User-Agent");
			
			response.reset();
			response.setContentType("application/octet-stream");
			response.setHeader("Content-Description", "JSP Generated Data");
			
			if(!skip) {
				if(client.indexOf("MSIE") != -1) {
					response.setHeader("Content-Disposition", "attachment; realFile="+new String(dataName.getBytes("KSC5601"),"ISO8859_1"));

				} else {
					dataName = new String(dataName.getBytes("utf-8"),"iso-8859-1");
					response.setHeader("Content-Disposition", "attachment; filename=\"" + dataName + "\"");
					response.setHeader("Content-Type", "application/octet-stream; charset=utf-8");
				}
				
				response.setHeader("Content-Length", ""+file.length());
				
				os = response.getOutputStream();
				byte b[] = new byte[(int)file.length()];
				int leng = 0;
				res=1;
				while((leng=in.read(b)) >0) {
					os.write(b, 0, leng);
				}
			} else {
				response.setContentType("text/html;charset=UTF-8");
				System.out.println("<script language='javascript'>alert('파일을 찾을 수 없습니다.');history.bach();</script>");
			}
			
			in.close();
			os.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	
	//해당 회의록의 모든 첨부파일 가져오기
	public ArrayList<MeetingDataInfo> allData(int met_numb) {
		ArrayList<MeetingDataInfo> list = new ArrayList<MeetingDataInfo>();
		PreparedStatement pstmt = null;
		String query = "SELECT * FROM rex_meetingdata WHERE data_met=?";
		openConnection();
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, met_numb);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()==true) {
				MeetingDataInfo metData = new MeetingDataInfo();
				metData.setData_met(rs.getInt("data_met"));
				metData.setData_name(rs.getString("data_name"));
				metData.setData_real_name(rs.getString("data_real_name"));
				metData.setData_numb(rs.getInt("data_numb"));
				list.add(metData);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return list;
	}
	
	//특정 첨부파일 가져오기
	public MeetingDataInfo detailData(int data_numb) {
		PreparedStatement pstmt = null;
		MeetingDataInfo metData = new MeetingDataInfo();
		String query = "SELECT * FROM rex_meetingdata WHERE data_numb=?";
		openConnection();
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, data_numb);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			metData.setData_numb(rs.getInt("data_numb"));
			metData.setData_name(rs.getString("data_name"));
			metData.setData_real_name(rs.getString("data_real_name"));
			metData.setData_met(rs.getInt("data_met"));
			rs.close();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return metData;
	}
	//하나의 파일삭제
	public int realDelete(String savePath, String realName) {
		int res=0;
		try {
			File file = new File(savePath + "\\" +realName);
			if (file.delete()) {
				res=1;
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	
	//db파일삭제
	public int deleteData(int didx) {
		PreparedStatement pstmt = null;
		String query = "DELETE FROM rex_meetingdata WHERE data_numb=?";
		int res = 0;
		openConnection();
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, didx);
			res = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return res;
	}
}
