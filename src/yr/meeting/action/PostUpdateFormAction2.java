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


public class PostUpdateFormAction2 implements CommandAction{
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("utf-8");

		MeetingInfo post = new MeetingInfo();
		MeetingDao data = new MeetingDao();
		String num = request.getParameter("met_numb");
		int midx = Integer.parseInt(num);
		post = data.detailPost(midx);
		
//		ArrayList<MeetingDataInfo> metData = new ArrayList<MeetingDataInfo>();
		MeetingDataDao metDatadao = new MeetingDataDao();
		
		
		List<MeetingDataInfo> metlist= new ArrayList<>();
		metlist=(metDatadao.allData(midx));
		
		request.setAttribute("post", post);
		request.setAttribute("metlist", metlist);
		
		return "post_update2.jsp";
	}
}
