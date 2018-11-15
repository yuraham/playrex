package yr.meeting.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.controller.CommandAction;
import sk.management.ManagementDao;
import sk.management.ManagementInfo;
import yr.meeting.MeetingDao;
import yr.meeting.MeetingInfo;
import yr.meetingdata.MeetingDataDao;

public class PostListAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("utf-8");
		
		ArrayList<ManagementInfo> member = new ArrayList<>();
		ManagementDao memdata = new ManagementDao();
		MeetingDao data = new MeetingDao();
		
		String col = request.getParameter("col");
		String word = request.getParameter("word");
		
		List<MeetingInfo> searchlist = data.searchList(col, word);
		MeetingDataDao metDatadao = new MeetingDataDao();
		ArrayList<Integer> metData = new ArrayList<>(); 
		
		String text = null;
		int memnumb = 0;
		int metnumb = 0;
		int dataNum = 0;
		
		int num = data.postCount();
		if(num == 0) {
			text = "등록된 회의록이 없습니다.";
		} else {
			if (col == null) {
				text = "총 게시글 "+ num;
			} else {
				text = "검색어 : "+word+"("+col+")"; 
			}
		}
		
		for (int i=0; i<searchlist.size();i++) {
			memnumb = searchlist.get(i).getMet_writer();
			metnumb = searchlist.get(i).getMet_numb();
			member.add(memdata.getManagement(memnumb));
			dataNum = metDatadao.allData(metnumb).size();
			metData.add(dataNum);
		}
		
		request.setAttribute("member", member);
		request.setAttribute("list", searchlist);
		request.setAttribute("text", text);
		request.setAttribute("metData", metData);
		
		return "post_list.jsp";
	}

}
