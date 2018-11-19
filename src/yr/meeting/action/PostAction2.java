package yr.meeting.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import member.controller.CommandAction;
import yr.meeting.MeetingDao;
import yr.meeting.MeetingInfo;
import yr.meetingdata.MeetingDataDao;


public class PostAction2 implements CommandAction{
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("utf-8");
		
		MeetingDao data = new MeetingDao();
		MeetingDataDao mdata = new MeetingDataDao();
		
		int maxSize = 10*1024*1024;
		String root = request.getSession().getServletContext().getRealPath("/");
		String savePath = root+"upload";
		MultipartRequest multi = new MultipartRequest(request, savePath, maxSize, "utf-8", new DefaultFileRenamePolicy());
		
		String text = multi.getParameter("met_text");
		List<MeetingInfo> list = data.searchList(null, null);
		int midx = list.get(0).getMet_numb();
		
		List<String> mlist = mdata.insertFile(multi, savePath, midx);
		String fileName = "";
		String realName = "";
		fileName = mlist.get(0);
		realName = mlist.get(1);
		
		if (fileName != "") {
			mdata.insertData(fileName, realName, midx);
		}
		
		data.updatePost2(text, midx);
		String text2 = "detail.do?met_numb="+midx;
		
		return text2;
	}
}
