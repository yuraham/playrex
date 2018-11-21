package yr.meeting.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.controller.CommandAction;
import yr.meeting.MeetingDao;
import yr.meeting.MeetingInfo;

public class PostFormAction2 implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("utf-8");
		
		MeetingInfo post = new MeetingInfo();
		MeetingDao data = new MeetingDao();
		
		List<MeetingInfo> list = data.searchList(null, null);
		
		int allnum = list.get(0).getMet_numb();
		post=data.detailPost(allnum);
		
		request.setAttribute("post", post);
		
		return "post_form2.jsp";
	}
}
