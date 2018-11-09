package yr.meeting.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.controller.CommandAction;

public class PostAction2 implements CommandAction{
			@Override
			public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
				request.setCharacterEncoding("utf-8");
				
		/*		CommonMeetingAction util = new CommonMeetingAction();
				MeetingInfo post = util.mappingReqMemo(request);
				MeetingDao data = new MeetingDao();*/
		 
				return "list.do";
			}
}
