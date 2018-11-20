package sk.picture;

import java.sql.PreparedStatement;
import java.sql.Blob;
import javax.sql.rowset.serial.SerialBlob;

import playconnection.RexConnection;

public class PictureDao extends RexConnection{
	//파일첨부
	public int insertFile(byte[] file, int worker_number, String fileName, long siz) {
		PreparedStatement pstmt = null;
		String query = "INSERT INTO rex_picture VALUES(null,?,?,?,?,now())";
		int res = 0;
		openConnection();
		try {
			pstmt=con.prepareStatement(query);
			pstmt.setInt(1, worker_number);
			Blob blob = new SerialBlob(file);
			pstmt.setBlob(2, blob);
			pstmt.setString(3, fileName);
			pstmt.setLong(4, siz);
			res = pstmt.executeUpdate();
			
		}catch(Exception e) {e.printStackTrace();}finally {
			closeConnection();
		}
		
		return res;
		
	}
	

}
