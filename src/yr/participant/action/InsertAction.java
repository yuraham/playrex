package yr.participant.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.controller.CommandAction;
import sk.management.ManagementDao;
import sk.management.ManagementInfo;
import yr.meeting.MeetingDao;
import yr.meeting.MeetingInfo;
import yr.participant.ParticipantDao;
//import yr.participant.ParticipantInfo;

public class InsertAction implements CommandAction{
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("utf-8");

		MeetingInfo meeting = new MeetingInfo();
		MeetingDao data = new MeetingDao();
		
		ManagementInfo member = new ManagementInfo();
		ManagementDao memdata = new ManagementDao();
		
		ParticipantDao partdata = new ParticipantDao();		
		List<MeetingInfo> list = data.searchList(null, null);
		
		int allnum = list.get(0).getMet_numb();
		meeting = data.detailPost(allnum);
		
		String text = "";
		
		for (int i=1; i<9; i++) {
			text = "part"+i;
			String partnum = request.getParameter(text);
			if (partnum == "") {
				continue;
			}
			int numb = Integer.parseInt(partnum);
			member = memdata.getManagement(numb);
			partdata.insertPartic(meeting.getMet_numb(), member.getWorker_number());
		}
		
		
		return "post_form2.do";
}
}
