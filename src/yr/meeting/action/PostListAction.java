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

public class PostListAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("utf-8");
		
		MeetingDao data = new MeetingDao();
		List<MeetingInfo> list = data.allPost();
		ArrayList<ManagementInfo> member = new ArrayList<>();
		ManagementDao memdata = new ManagementDao();

		String text=null;
		
		int num = data.postCount();
		if(list == null) {
			text = "등록된 회의록이 없습니다.";
		} else {
			text = "총 게시글 "+ num;
		}
		
		for (int i=0; i<list.size();i++) {
			int memnumb = list.get(i).getMet_writer();
			member.add(memdata.getManagement(memnumb));
		}

		request.setAttribute("member", member);
		request.setAttribute("num", num);
		request.setAttribute("list", list);
		request.setAttribute("text", text);
		
		return "post_list.jsp";
	}

}
