package yr.meeting.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.controller.CommandAction;
import yr.meeting.MeetingDao;
import yr.meeting.MeetingInfo;

public class PostDeleteEndAction implements CommandAction {
	
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		MeetingDao data = new MeetingDao();
		List<MeetingInfo> list = data.searchList(null, null);
		
		String numb = request.getParameter("met_numb");
		int midx = 0;
		
		if(numb != null) {
			midx = Integer.parseInt(numb);
		} else {
			midx = list.get(0).getMet_numb();
		}
		
		data.deletePost(midx);

		return "list.do";
	}
}
