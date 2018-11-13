package yr.meeting.action;

import java.util.List;

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
		
		List<MeetingInfo> list = data.allPost();
		int allnum = list.get(list.size() - 1).getMet_numb();

		data.updatePost2(post, allnum);
		String text = "detail.do?met_numb="+allnum;
				
		return text;
	}
}
