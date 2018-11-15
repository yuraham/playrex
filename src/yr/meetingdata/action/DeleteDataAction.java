package yr.meetingdata.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.controller.CommandAction;
import yr.meetingdata.MeetingDataDao;
//import yr.meetingdata.MeetingDataInfo;

public class DeleteDataAction implements CommandAction{
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("utf-8");
		
//		MeetingDataInfo metData = new MeetingDataInfo();
		MeetingDataDao metDatadao = new MeetingDataDao();
		String numb = request.getParameter("met_numb");
		int midx = Integer.parseInt(numb);
		String dnumb = request.getParameter("data_numb");
		int didx = Integer.parseInt(dnumb);
		
		metDatadao.deleteData(didx, midx);
		
		return "update_form2.do";
	}
}
