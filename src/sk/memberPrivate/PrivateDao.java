package sk.memberPrivate;

import java.sql.PreparedStatement;

import playconnection.RexConnection;

public class PrivateDao extends RexConnection{
	
	////회원가입
	public int insertPrivate(PrivateInfo privacy) {
		PreparedStatement pstmt = null;
		String query = "INSERT INTO rex_private VALUES(?,?,?,?,?,?,now())";
		int res = 0;
		openConnection();
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, privacy.getWorker_number());
			pstmt.setString(2, privacy.getPass());
			pstmt.setString(3, privacy.getPhone());
			pstmt.setString(4, privacy.getPhone2());
			pstmt.setString(5, privacy.getE_mail());
			pstmt.setString(6, privacy.getAddress());
			res = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return res;
	}
	
	
	
	//정보수정
	//정보 조회 

}
