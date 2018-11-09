package yr.participant;

import java.sql.PreparedStatement;
import playconnection.RexConnection;

public class ParticipantDao extends RexConnection{

	//참가자 등록
	public int insertPartic(int met_numb, int man_numb) {
		PreparedStatement pstmt = null;
		String query = "INSERT INTO rex_participant(par_numb, par_enum, par_met) VALUES (null,?,?);";
		int res=0;
		openConnection();
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, met_numb);
			pstmt.setInt(2, man_numb);
			res = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return res;
	}

	//참가자 삭제
	public int deletePartic(int met_numb, int man_numb) {
		PreparedStatement pstmt = null;
		String query = "DELETE FROM rex_participant WHERE par_enum=? AND par_met=?";
		int res=0;
		openConnection();
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, met_numb);
			pstmt.setInt(2, man_numb);
			res = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return res;
	}
}
