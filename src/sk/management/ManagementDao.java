package sk.management;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import playconnection.RexConnection;

public class ManagementDao extends RexConnection {

	//// 인사정보 등록
	public int insertManagement(ManagementInfo management) {
		PreparedStatement pstmt = null;
		String query = "INSERT INTO rex_management VALUES(null,?,?, ?, now(), null, 1, ?, null)";
		int res = 0;
		openConnection();
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, management.getName());
			pstmt.setString(2, management.getDivision());
			pstmt.setString(3, management.getPosition());
			pstmt.setString(4, management.getMemo());
			res = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return res;
	}

	//// 사원 등록 조회
	public boolean isManagement(Integer worker_num, String name) {
		PreparedStatement pstmt = null;
		String query = "SELECT * FROM rex_management where worker_number=?  AND name=?";
		boolean res = false;

		openConnection();
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, worker_num);
			pstmt.setString(2, name);

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

	// 인사정보 조회
	public ManagementInfo getManagement(Integer worker_number) {
		PreparedStatement pstmt = null;
		ManagementInfo management = new ManagementInfo();
		String query = "SELECT * FROM rex_management where worker_number=?";

		openConnection();
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, worker_number);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			management.setWorker_number(rs.getInt("worker_number"));
			management.setName(rs.getString("name"));
			management.setDivision(rs.getString("division"));
			management.setPosition(rs.getString("position"));
			management.setJoin_date(rs.getTimestamp("join_date"));
			management.setLeave_date(rs.getTimestamp("leave_date"));
			management.setActive(rs.getInt("active"));
			management.setAuthority(rs.getString("authority"));
			management.setMemo(rs.getString("memo"));
			rs.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return management;
	}

	// 인사정보 수정
	// 정보수정 기록 조회

}
