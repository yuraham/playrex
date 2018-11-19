package yr.meeting.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.controller.CommandAction;
import yr.meeting.MeetingDao;
import yr.meeting.MeetingInfo;
import yr.meetingdata.MeetingDataDao;
import yr.meetingdata.MeetingDataInfo;

public class PostDeleteAction implements CommandAction{
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("utf-8");
		
		MeetingInfo post = new MeetingInfo();
		MeetingDao data = new MeetingDao();
		String numb = request.getParameter("met_numb");
		int midx = Integer.parseInt(numb);
		
		List<MeetingDataInfo> metlist= new ArrayList<>();
		MeetingDataDao mData = new MeetingDataDao();
		metlist=(mData.allData(midx));
		
		post=data.detailPost(midx);
		request.setAttribute("post", post);
		request.setAttribute("metlist", metlist);
		
		return "post_delete.jsp";
	}
}
