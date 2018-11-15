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
import yr.meetingdata.MeetingDataInfo;
import yr.participant.ParticipantDao;
import yr.participant.ParticipantInfo;

public class PostDetailAction implements CommandAction{
	
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("utf-8");
		
		MeetingInfo post = new MeetingInfo();
		MeetingDao data = new MeetingDao();
		String text = null;
		String numb = request.getParameter("met_numb");
		int midx = Integer.parseInt(numb);
		post = data.detailPost(midx);
		ManagementInfo member = new ManagementInfo();
		ManagementDao memdata = new ManagementDao();
		ParticipantDao partdata = new ParticipantDao();
		MeetingDataDao metDatadao = new MeetingDataDao();
		
		if(post == null) {
			text = "Fail: idx = " + midx;
			return "index.jsp";
		} else {
			text = midx+"번글";
		}
		
		int memnumb = post.getMet_writer();
		member = memdata.getManagement(memnumb);
		
		List<ParticipantInfo> part = partdata.allPart(midx);
		List<ManagementInfo> memberlist= new ArrayList<>();
		List<MeetingDataInfo> metlist= new ArrayList<>();
		metlist=(metDatadao.allData(midx));
		if (part != null) {
			for (int i=0; i<part.size();i++) {
				int memnum = part.get(i).getPar_enum();
				memberlist.add(memdata.getManagement(memnum));
			}
		}
		
		request.setAttribute("member", member);
		request.setAttribute("memberlist", memberlist);
		request.setAttribute("post", post);
		request.setAttribute("part", part);
		request.setAttribute("text", text);
		request.setAttribute("metlist", metlist);
		
		return "post_detail.jsp";
	}
}
