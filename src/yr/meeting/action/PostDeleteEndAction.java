package yr.meeting.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.controller.CommandAction;
import yr.meeting.MeetingDao;
//import yr.meeting.MeetingInfo;
import yr.meetingdata.MeetingDataDao;
import yr.meetingdata.MeetingDataInfo;

public class PostDeleteEndAction implements CommandAction {
	
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		MeetingDao data = new MeetingDao();
		
		String numb = request.getParameter("met_numb");
		int midx = Integer.parseInt(numb);

		String root = request.getSession().getServletContext().getRealPath("/");
		String savePath = root + "upload";
		MeetingDataDao mData = new MeetingDataDao();
		List<MeetingDataInfo> metlist= new ArrayList<>();
		
		metlist=(mData.allData(midx));
		String realName = "";
		if (metlist.size() > 0) {
			for(int i=0; i<metlist.size(); i++) {
				realName = metlist.get(i).getData_real_name();
				mData.realDelete(savePath, realName);
			}
		}
		
		data.deletePost(midx);
		
		return "list.do";
	}
}
