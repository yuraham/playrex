package yr.meeting.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.controller.CommandAction;
import yr.meeting.CommonMeetingAction;
import yr.meeting.MeetingDao;
import yr.meeting.MeetingInfo;
import yr.participant.ParticipantDao;
import yr.participant.ParticipantInfo;

public class PostUpdateAction implements CommandAction{
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("utf-8");		
		String num = request.getParameter("met_numb");
		int midx = Integer.parseInt(num);
		
		CommonMeetingAction util = new CommonMeetingAction();
		MeetingInfo post = util.mappingReqMemo(request);
		MeetingDao data = new MeetingDao();
		
		data.updatePost(post, midx);
		
		ParticipantDao partdata = new ParticipantDao();
		List<ParticipantInfo> oripart = new ArrayList<>();
		List<Integer> part = new ArrayList<>();
		List<Integer> part2 = new ArrayList<>();
		oripart = partdata.allPart(midx);
		String text="";
		
		for (int i=1; i<9; i++) {
			text = "part"+i;
			String partnum = request.getParameter(text);
			int numb = Integer.parseInt(partnum);
			part.add(numb);
		}
		
		for (int i=0; i<oripart.size(); i++) {
			int mynum = oripart.get(i).getPar_enum();
			part2.add(mynum);
		}
		
//		part.retainAll(part2);
		
		request.setAttribute("post", post);
		
		return "update_form2.do";
	}

}
