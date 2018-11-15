package yr.meetingdata.action;

//import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.controller.CommandAction;
import yr.meeting.MeetingDao;
import yr.meeting.MeetingInfo;
import yr.meetingdata.MeetingDataDao;

public class UploadDataAction implements CommandAction{
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("utf-8");
		
		
		MeetingDao data = new MeetingDao();
		MeetingDataDao mdata = new MeetingDataDao();
		
		List<MeetingInfo> list = data.searchList(null, null);
		int allnum = list.get(0).getMet_numb();
		
		List<String> mlist = mdata.insertFile(request, allnum);
		String fileName = "";
		String realName = "";
		if (fileName != null) {
			fileName = mlist.get(0);
			realName = mlist.get(1);
			mdata.insertData(fileName, realName, allnum);
		}
		
		String text = "detail.do?met_numb="+allnum;
		
		return text;
	}
}
