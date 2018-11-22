package yr.meeting.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import member.controller.CommandAction;
import yr.meeting.MeetingDao;
//import yr.meeting.MeetingInfo;
import yr.meetingdata.MeetingDataDao;

public class PostUpdateAction2 implements CommandAction{
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
		String numb = multi.getParameter("met_numb");
		int midx = Integer.parseInt(numb);
		text = text.replace("\r\n", "<br>");
		
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




/*
// 이름으로 검색하여 사원리스트 가져오는 코드 작성하기
ManagementDao memdata = new ManagementDao();
String name = request.getParameter("name");
ManagementInfo management = new ManagementInfo();
int i = 0;
StringBuffer list = new StringBuffer();

//이름으로 검색하여 사번을 알아낸다. 사번을 리스트로 관리하여  리스트를 포문으로 돌린다.
for(i=1; i<30; i++) {
if(memdata.isManagement2(i) ) {
	if(memdata.getManagement(i).getName().equals(name)) {
	 
	management = memdata.getList(name, i);
	list.append("<tr><td>");
	list.append(management.getWorker_number());
	list.append("</td><td>");
	list.append(management.getName());
	list.append("</td></tr>");
		}
	}
}

request.setAttribute("List", list);*/