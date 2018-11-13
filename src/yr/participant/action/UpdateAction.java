package yr.participant.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.controller.CommandAction;
//import yr.meeting.CommonMeetingAction;
//import yr.meeting.MeetingDao;
//import yr.meeting.MeetingInfo;
import yr.participant.ParticipantDao;
import yr.participant.ParticipantInfo;

public class UpdateAction implements CommandAction{
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("utf-8"); 

		ParticipantDao data = new ParticipantDao();
		List<ParticipantInfo> oripart = new ArrayList<>();
		List<Integer> part = new ArrayList<>();
		
		String num = request.getParameter("met_numb");
		int midx = Integer.parseInt(num);
		oripart = data.allPart(midx);
		
		String text="";
		
		for (int i=1; i<9; i++) {
			text = "part"+i;
			String partnum = request.getParameter(text);
			if (partnum == "") continue;
			int numb = Integer.parseInt(partnum);
			part.add(numb);
		}
		
		if(oripart != null) {
			for(int j=0; j<oripart.size(); j++) {
				int partnumb = (Integer)oripart.get(j).getPar_enum();
				data.deletePartic(midx, partnumb);
			}
		}
		if(part != null) {
			for(int k=0; k<part.size(); k++) {
				data.insertPartic(midx, part.get(k));
			}
		}
		
		return "update_form2.do";
	}
}
