package yr.meeting.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.controller.CommandAction;
import yr.meeting.MeetingDao;
import yr.meeting.MeetingInfo;

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
		
		if(post == null) {
			text = "Fail: idx = " + midx;
			return "index.jsp";
		} else {
			text = midx+"번글";
		}
		
		request.setAttribute("post", post);
		request.setAttribute("text", text);
		
		return "post_detail.jsp";
	}
}
