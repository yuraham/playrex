package yr.meeting;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

public class CommonMeetingAction {

	public MeetingInfo mappingReqMemo(HttpServletRequest request) throws Throwable {
		MeetingInfo memo = new MeetingInfo();
		Enumeration<String> parameterNames = request.getParameterNames();
		
		while(parameterNames.hasMoreElements()) {
			String paramName = (String)parameterNames.nextElement();
			switch(paramName) {
			case "met_title":
				memo.setMet_title(request.getParameter("met_title"));
				break;
			case "met_room":
				memo.setMet_room(request.getParameter("met_room"));
				break;
			case "met_project":
				memo.setMet_project(request.getParameter("met_project"));
				break;
			case "met_text":
				memo.setMet_text(request.getParameter("met_text"));
				break;
			}
		}
		return memo;
	}
}


