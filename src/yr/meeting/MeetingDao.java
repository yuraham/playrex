package yr.meeting;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import playconnection.RexConnection;

public class MeetingDao extends RexConnection{
	
	//게시글 개수 얻기
	public int postCount() {
		Statement stmt = null;
		String query = "SELECT * FROM rex_meeting";
		int count=0;
		openConnection();
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			rs.last();
			count = rs.getRow();
			rs.beforeFirst();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return count;
	}
	
	//모든 포스트 가져오기
	public List<MeetingInfo> allPost() {
		List<MeetingInfo> list = null;
		Statement stmt = null;
		String query = "SELECT "
	}
	//특정 포스트 데이터 가져오기
	//등록하기
	//수정하기
	//삭제하기
	
}
