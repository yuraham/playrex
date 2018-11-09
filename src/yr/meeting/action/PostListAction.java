package yr.meeting.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.controller.CommandAction;
//import sk.management.ManagementDao;
//import sk.management.ManagementInfo;
import yr.meeting.MeetingDao;
import yr.meeting.MeetingInfo;

public class PostListAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("utf-8");
		
//		MeetingInfo post = new MeetingInfo();
		MeetingDao data = new MeetingDao();
		String text=null;
		
		int num = data.postCount();
		List<MeetingInfo> list = data.allPost();
		
		
		if(list == null) {
			text = "등록된 회의록이 없습니다.";
		} else {
			text = "총 게시글 "+ num;
		}
//		ManagementInfo member = new ManagementInfo();
		
		
//		member = data.writerName(post.getMet_numb());

//		request.setAttribute("member", member);
		request.setAttribute("num", num);
		request.setAttribute("list", list);
		request.setAttribute("text", text);
		
		return "/yr_meeting/post_list.jsp";
	}

}
