package sk.memberPrivate;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import playconnection.RexConnection;

public class PrivateDao extends RexConnection {

	//// 회원가입
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
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return res;
	}

	//// 개인정보 조회
	public PrivateInfo getPrivate(Integer worker_number) {
		PreparedStatement pstmt = null;
		PrivateInfo privacy = new PrivateInfo();
		String query = "SELECT * FROM rex_private where worker_number=?";

		openConnection();
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, worker_number);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			privacy.setWorker_number(rs.getInt("worker_number"));
			// privacy.setName(rs.getString("name"));
			privacy.setPass(rs.getString("pass"));
			privacy.setPhone(rs.getString("phone"));
			privacy.setPhone2(rs.getString("phone2"));
			privacy.setE_mail(rs.getString("e_mail"));
			privacy.setAddress(rs.getString("address"));
			privacy.setReg_date(rs.getTimestamp("reg_date"));
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return privacy;

	}
	
	//회원가입 여부 확인(사이트 가입 확인)
	public boolean siteMember(Integer worker_number) {
		PreparedStatement pstmt = null;
		String query ="SELECT * FROM rex_private WHERE worker_number=?";
		boolean res = false;
		openConnection();
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, worker_number);
			ResultSet rs = pstmt.executeQuery();
			res = rs.next();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return res;
		
	}

	// 회원가입 여부 확인(로그인 할때)
	public boolean isMember(Integer worker_number, String pass) {
		PreparedStatement pstmt = null;
		String query = "SELECT * FROM rex_private WHERE worker_number=? AND pass=?";
		boolean res = false;

		openConnection();
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, worker_number);
			pstmt.setString(2, pass);

			ResultSet rs = pstmt.executeQuery();
			res = rs.next();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return res;

	}

	// 정보수정
	public int updateMember(PrivateInfo privacy, Integer worker_number) {
		PreparedStatement pstmt = null;
		String query = "UPDATE rex_private SET pass=?, phone=?,phone2=?, e_mail=?, address=? WHERE worker_number = ?;";
		int res = 0;
		openConnection();
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, privacy.getPass());
			pstmt.setString(2, privacy.getPhone());
			pstmt.setString(3, privacy.getPhone2());
			pstmt.setString(4, privacy.getE_mail());
			pstmt.setString(5, privacy.getAddress());
			pstmt.setInt(6, worker_number);

			res = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			;
		} finally {
			closeConnection();
		}
		return res;

	}
	
	

//	public int updateMember2(PrivateInfo privacy, Integer worker_number) {
//		PreparedStatement pstmt = null;
//		String query = "UPDATE rex_private SET phone=?,phone2=?, e_mail=?, address=? WHERE worker_number = ?;";
//		int res = 0;
//		openConnection();
//		try {
//			pstmt = con.prepareStatement(query);
//			pstmt.setString(1, privacy.getPhone());
//			pstmt.setString(2, privacy.getPhone2());
//			pstmt.setString(3, privacy.getE_mail());
//			pstmt.setString(4, privacy.getAddress());
//			pstmt.setInt(5, worker_number);
//
//			res = pstmt.executeUpdate();
//		} catch (Exception e) {
//			e.printStackTrace();
//			;
//		} finally {
//			closeConnection();
//		}
//		return res;
//
//	}

}
