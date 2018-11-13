package yr.participant;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
			pstmt.setInt(1, man_numb);
			pstmt.setInt(2, met_numb);
			res = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return res;
	}
	
	//특정 게시글에 참여한 사람들 목록
	public List<ParticipantInfo> allPart(int met_numb) {
		List<ParticipantInfo> list = null;
		PreparedStatement pstmt = null; 
		String query = "SELECT par_enum FROM rex_participant WHERE par_met=?";
		openConnection();
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, met_numb);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				list=new ArrayList<>();
				do {
					ParticipantInfo part = new ParticipantInfo(); 
					part.setPar_enum(rs.getInt("par_enum"));
					list.add(part);
				} while(rs.next());
			}
			rs.close();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return list;
	}
	
	//참가자 삭제
	public int deletePartic(int met_numb, int man_numb) {
		PreparedStatement pstmt = null;
		String query = "DELETE FROM rex_participant WHERE par_enum=? AND par_met=?";
		int res=0;
		openConnection();
		
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, man_numb);
			pstmt.setInt(2, met_numb);
			res = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return res;
	}
}
