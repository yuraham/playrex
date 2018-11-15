package sk.update;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import playconnection.RexConnection;

public class InsertUpdateDao extends RexConnection {

	public int insertUpdate(InsertUpdateInfo update, int worker_number) {
		PreparedStatement pstmt = null;
		String query = "INSERT INTO rex_update VALUES(null, ?, ?, ?, ?, ?, now())";
		int res = 0;
		openConnection();
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, worker_number);
			pstmt.setString(2, update.getCategory());
			pstmt.setString(3, update.getFiled_name());
			pstmt.setString(4, update.getOld_data());
			pstmt.setString(5, update.getNew_data());
			res = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return res;
	}

	public InsertUpdateInfo getList(Integer worker_number, String category, int num) {
		PreparedStatement pstmt = null;
		InsertUpdateInfo update = new InsertUpdateInfo();
		String query = "SELECT * FROM rex_update WHERE worker_number=? AND category=? AND num=?";
		openConnection();
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, worker_number);
			pstmt.setString(2, category);
			pstmt.setInt(3, num);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			update.setWorker_number(worker_number);
			update.setCategory(category);
			update.setFiled_name(rs.getString("filed_name"));
			update.setOld_data(rs.getString("old_data"));
			update.setNew_data(rs.getString("new_data"));
			update.setUpdate_date(rs.getTimestamp("update_date"));
			update.setNum(rs.getInt("num"));
			rs.close();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return update;

	}

	public int getLastNum(String category, int worker_number) {
		PreparedStatement pstmt = null;
		InsertUpdateInfo update = new InsertUpdateInfo();
		int num = 0;
		String query = "SELECT * FROM rex_update WHERE category=? AND worker_number=? ORDER BY num DESC LIMIT 1 ";
		openConnection();
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, category);
			pstmt.setInt(2, worker_number);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			update.setNum(rs.getInt("num"));
			rs.close();
			num = update.getNum();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return num;

	}

	public boolean isNumManagement(int num, int worker_number) {
		PreparedStatement pstmt = null;
		boolean res = false;
		String query = "Select * from rex_update where num = ? AND category=\"인사정보\" AND worker_number=?";
		openConnection();
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, num);
			pstmt.setInt(2, worker_number);
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

	public boolean isNumPrivate(int num, int worker_number) {
		PreparedStatement pstmt = null;
		boolean res = false;
		String query = "Select * from rex_update where num = ? AND category=\"개인정보\" AND worker_number=?";
		openConnection();
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, num);
			pstmt.setInt(2, worker_number);
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

}