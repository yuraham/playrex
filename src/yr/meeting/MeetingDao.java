package yr.meeting;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
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
		String query = "SELECT met_numb, met_title, met_date, met_writer, met_project FROM rex_meeting";
		openConnection();
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			if(rs.next()) {
				list = new ArrayList<>();
				do {
					MeetingInfo post = new MeetingInfo();
					post.setMet_numb(rs.getInt("met_numb"));
					post.setMet_title(rs.getString("met_title"));
					post.setMet_date(rs.getTimestamp("met_date"));
					post.setMet_writer(rs.getInt("met_writer"));
					post.setMet_project(rs.getString("met_project"));
					list.add(post);
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
	
	//특정 포스트 데이터 가져오기
	public MeetingInfo detailPost(int met_numb) {
		PreparedStatement pstmt = null;
		MeetingInfo post = new MeetingInfo();
		String query = "SELECT * FROM rex_meeting WHERE met_numb = ?";
		openConnection();
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, met_numb);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			post.setMet_numb(rs.getInt("met_numb"));
			post.setMet_title(rs.getString("met_title"));
			post.setMet_room(rs.getString("met_room"));
			post.setMet_project(rs.getString("met_project"));
			post.setMet_subject(rs.getString("met_subject"));
			post.setMet_text(rs.getString("met_text"));
			post.setMet_date(rs.getTimestamp("met_date"));
			post.setMet_writer(rs.getInt("met_writer"));
			rs.close();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return post;
	}
	//등록하기
	public int insertPost(MeetingInfo post) {
		PreparedStatement pstmt = null;
		String query = "INSERT INTO rex_meeting (met_numb, met_title, met_room, met_project, met_subject, met_text, met_date, met_writer)" + 
				"VALUES (null, ?,?,?,?,null, now(),?)";
		int res=0;
		openConnection();
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, post.getMet_title());
			pstmt.setString(2, post.getMet_room());
			pstmt.setString(3, post.getMet_project());
			pstmt.setString(4, post.getMet_subject());
			pstmt.setInt(5, post.getMet_writer());
			res = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return res;
	}
	
	//수정하기
	public int updatePost(MeetingInfo post, int met_numb) {
		PreparedStatement pstmt = null;
		String query = "UPDATE rex_meeting SET met_title=?,"
				+ "met_room=?, met_project=?,"
				+ "met_subject=?, met_writer=? WHERE met_numb=?;";
		int res = 0;
		openConnection();
		try {			
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, post.getMet_title());
			pstmt.setString(2, post.getMet_room());
			pstmt.setString(3, post.getMet_project());
			pstmt.setString(4, post.getMet_subject());
			pstmt.setInt(5, post.getMet_writer());
			pstmt.setInt(6, met_numb);
			res = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return res;
	}
	
	//수정, 등록에서 텍스트 집어넣기
	public int updatePost2(MeetingInfo post, int met_numb) {
		PreparedStatement pstmt = null;
		String query = "UPDATE rex_meeting SET met_text=? WHERE met_numb=?";
		int res = 0;
		openConnection();
		try {			
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, post.getMet_text());
			pstmt.setInt(2, met_numb);
			res = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return res;
	}
	
	//삭제하기
	public int deletePost(int met_numb) {
		PreparedStatement pstmt = null;
		String query = "DELETE FROM rex_meeting WHERE met_numb=?";
		int res = 0;
		openConnection();
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, met_numb);
			res = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return res;
	}
	
	//포스트가 있는지 확인하기
	public boolean isPost(int met_numb) {
		PreparedStatement pstmt=null;
		String query="SELECT * FROM rex_meeting WHERE met_numb=?";
		boolean res = false;
		openConnection();
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, met_numb);
			ResultSet rs = pstmt.executeQuery();
			res = rs.next();
			rs.close();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return res;
	}
	
}
