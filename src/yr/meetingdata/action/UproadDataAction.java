package yr.meetingdata.action;

//import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.controller.CommandAction;
import yr.meeting.MeetingDao;
import yr.meeting.MeetingInfo;
import yr.meetingdata.MeetingDataDao;

public class UproadDataAction implements CommandAction{
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("utf-8");
		
		MeetingDao data = new MeetingDao();
		MeetingDataDao mdata = new MeetingDataDao();
		
		mdata.insertFile(request);
		List<MeetingInfo> list = data.searchList(null, null);
		int allnum = list.get(0).getMet_numb();
		
		String text = "detail.do?met_numb="+allnum;
		
		return text;
	}
}
