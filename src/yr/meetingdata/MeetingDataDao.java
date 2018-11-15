package yr.meetingdata;

import java.io.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import playconnection.RexConnection;

public class MeetingDataDao  extends RexConnection{
	
	//파일첨부
	public List<String> insertFile(HttpServletRequest request, int mit_numb) {
		int maxSize = 10*1024*1024;
		String root = request.getSession().getServletContext().getRealPath("/");
		String savePath = root+"upload";
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
			MultipartRequest multi = new MultipartRequest(request, savePath, maxSize, "utf-8", new DefaultFileRenamePolicy());
			//파일업로드
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
	
/*	public ArrayList<MeetingDataInfo> totalData() {
		ArrayList<MeetingDataInfo> list = new ArrayList<MeetingDataInfo>();
		PreparedStatement pstmt = null;
		String query = "SELECT * FROM rex_meetingdata";
		openConnection();
		try {
			pstmt=con.prepareStatement(query);
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
	}*/

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
	public MeetingDataInfo detailData(int met_numb, int data_numb) {
		PreparedStatement pstmt = null;
		MeetingDataInfo metData = new MeetingDataInfo();
		String query = "SELECT * FROM rex_meetingdata WHERE data_met=? AND data_numb=?";
		openConnection();
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, met_numb);
			pstmt.setInt(2, data_numb);
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
	
	//파일삭제
	public int deleteData(int didx, int midx) {
		PreparedStatement pstmt = null;
		String query = "DELETE FROM rex_meetingdata WHERE data_numb=?"
		+ " AND data_met=?";
		int res = 0;
		openConnection();
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, didx);
			pstmt.setInt(2, midx);
			res = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return res;
	}
}
