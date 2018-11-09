package yr.meeting.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.controller.CommandAction;
import yr.meeting.MeetingDao;

public class PostDeleteEndAction implements CommandAction {
	
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
//		MemoInfo memo = new MemoInfo();
		MeetingDao data = new MeetingDao();
		String numb = request.getParameter("met_numb");
		int midx = Integer.parseInt(numb);
		
		data.deletePost(midx);

		return "list.do";
	}
}
