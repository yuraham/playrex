package yr.meeting;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import playconnection.RexConnection;
//import sk.management.ManagementInfo;

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
	
	//작성자 검색
/*	public ManagementInfo writerName(int met_numb) {
		PreparedStatement pstmt = null;
		ManagementInfo member = new ManagementInfo();
		String query = "SELECT * FROM rex_management WHERE worker_number IN ("
				+ "SELECT met_writer FROM rex_meeting WHERE met_numb=?";
		openConnection();
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, met_numb);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			member.setName(rs.getString("name"));
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return member;
	}*/
	
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
	//수정하기
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
	
}
