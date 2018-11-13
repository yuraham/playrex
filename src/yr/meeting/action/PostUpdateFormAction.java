package yr.meeting.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.controller.CommandAction;
import yr.meeting.MeetingDao;
import yr.meeting.MeetingInfo;
import yr.participant.ParticipantDao;
import yr.participant.ParticipantInfo;


public class PostUpdateFormAction implements CommandAction{
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("utf-8");

		MeetingInfo post = new MeetingInfo();
		MeetingDao data = new MeetingDao();
		
		String num = request.getParameter("met_numb");
		int midx = Integer.parseInt(num);
		post = data.detailPost(midx);
		
		ParticipantDao partdata = new ParticipantDao();
		List<ParticipantInfo> part = partdata.allPart(midx);
		
		request.setAttribute("post", post);
		request.setAttribute("part", part);
		
		return "post_update.jsp";
	}
}
