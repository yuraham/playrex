package yr.meeting.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.controller.CommandAction;
import yr.meeting.CommonMeetingAction;
import yr.meeting.MeetingDao;
import yr.meeting.MeetingInfo;

public class PostUpdateAction implements CommandAction{
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("utf-8");		
		
		CommonMeetingAction util = new CommonMeetingAction();
		MeetingInfo post = util.mappingReqMemo(request);
		MeetingDao data = new MeetingDao();
		
		String num = request.getParameter("met_numb");
		int midx = Integer.parseInt(num);
		data.updatePost(post, midx);
		
		request.setAttribute("post", post);
		
		return "update_part.do";
	}

}
