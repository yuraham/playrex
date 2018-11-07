package sk.management.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.controller.CommandAction;
import sk.management.ManagementDao;
import sk.management.ManagementInfo;
import sk.memberPrivate.PrivateDao;
import sk.memberPrivate.PrivateInfo;
import sk.memberPrivate.action.CommonPrivateAc;

public class DetailAction implements CommandAction {
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		HttpSession session = request.getSession();
		ManagementDao data = new ManagementDao();
		PrivateDao data2 = new PrivateDao();
		ManagementInfo management = new ManagementInfo();
		PrivateInfo privacy = new PrivateInfo();
		int number = Integer.parseInt(request.getParameter("num"));
		
		CommonPrivateAc utils = new CommonPrivateAc();
		//사원등록을 확인한다. 
		if(data.isManagement2(number)) {
			management = data.getManagement(number);
			session.setAttribute("management", management);
		}
		
		
		if(data2.siteMember(number)) {
			privacy = data2.getPrivate(number);
			session.setAttribute("privacy", privacy);
		}else {
			privacy.setPhone("");
			privacy.setPhone2("");
			privacy.setE_mail("");
			privacy.setAddress("");
			session.setAttribute("privacy", privacy);
		}
		
		return "management_main.jsp";
	}

}
