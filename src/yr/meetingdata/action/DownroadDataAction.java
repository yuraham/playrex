package yr.meetingdata.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.controller.CommandAction;
import yr.meetingdata.MeetingDataDao;
import yr.meetingdata.MeetingDataInfo;

public class DownroadDataAction implements CommandAction{
	
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("utf-8");

		String num = request.getParameter("data_numb");
		int dnum = Integer.parseInt(num);
		
		String root = request.getSession().getServletContext().getRealPath("/");
		String savePath = root + "upload";

		MeetingDataInfo mData= new MeetingDataInfo();
		MeetingDataDao data = new MeetingDataDao();
		mData = data.detailData(dnum);
		
		String realFile = mData.getData_real_name();
		String dataName = mData.getData_name();
		int midx = mData.getData_met();

		data.downData(request, response, savePath, realFile, dataName);
		
		//forward가 두번 호출??? java.lang.IllegalStateException: Cannot forward after response has been committed 에러
		String text = "detail.do?met_numb="+midx;
		return text;
	}
}
