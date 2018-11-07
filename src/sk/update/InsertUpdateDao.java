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

	public InsertUpdateInfo getList(Integer worker_number, String category) {
		PreparedStatement pstmt = null;
		InsertUpdateInfo update = new InsertUpdateInfo();
		String query = "SELECT * FROM rex_update WHERE worker_number=? AND category=? LIMIT 1";
		openConnection();
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, worker_number);
			pstmt.setString(2, category);
			////
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			update.setWorker_number(worker_number);
			update.setCategory(category);
			/////
			update.setFiled_name(rs.getString("filed_name"));
			update.setOld_data(rs.getString("old_data"));
			update.setNew_data(rs.getString("new_data"));
			update.setUpdate_date(rs.getTimestamp("update_date"));
			rs.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return update;

	}

}
