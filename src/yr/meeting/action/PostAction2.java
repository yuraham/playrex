package yr.meeting.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.controller.CommandAction;
import yr.meeting.CommonMeetingAction;
import yr.meeting.MeetingDao;
import yr.meeting.MeetingInfo;


public class PostAction2 implements CommandAction{
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("utf-8");
		
		CommonMeetingAction util = new CommonMeetingAction();
		MeetingInfo post = util.mappingReqMemo(request);
		MeetingDao data = new MeetingDao();
		
		int allnum = data.postCount(); 
		int midx = allnum+1;
		data.updatePost2(post, midx);
		String text = "detail.do?met_numb="+midx;
				
		return text;
	}
}
