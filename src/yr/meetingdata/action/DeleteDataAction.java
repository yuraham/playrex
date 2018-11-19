package yr.meetingdata.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.controller.CommandAction;
import yr.meetingdata.MeetingDataDao;
import yr.meetingdata.MeetingDataInfo;

public class DeleteDataAction implements CommandAction{
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("utf-8");
		
		MeetingDataInfo mData = new MeetingDataInfo();
		MeetingDataDao data = new MeetingDataDao();
		String dnumb = request.getParameter("data_numb");
		int didx = Integer.parseInt(dnumb);
		
		String root = request.getSession().getServletContext().getRealPath("/");
		String savePath = root + "upload";
		
		mData = data.detailData(didx);
		String realName = mData.getData_real_name();

		data.realDelete(savePath, realName);
		data.deleteData(didx);
		
		return "update_form2.do";
	}
}
