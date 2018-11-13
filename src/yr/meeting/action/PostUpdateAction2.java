package yr.meeting.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.controller.CommandAction;
//import sk.management.ManagementDao;
//import sk.management.ManagementInfo;
import yr.meeting.CommonMeetingAction;
import yr.meeting.MeetingDao;
import yr.meeting.MeetingInfo;

public class PostUpdateAction2 implements CommandAction{
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("utf-8");
		
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
		
		CommonMeetingAction util = new CommonMeetingAction();
		MeetingInfo post = util.mappingReqMemo(request);
		MeetingDao data = new MeetingDao();
		
		String num = request.getParameter("met_numb");
		int midx = Integer.parseInt(num);		
		data.updatePost2(post, midx);
		
		request.setAttribute("post", post);
		
		return "detail.do";
	}

}
