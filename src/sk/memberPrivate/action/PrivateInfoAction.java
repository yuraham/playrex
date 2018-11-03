package sk.memberPrivate.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.controller.CommandAction;
import sk.management.ManagementDao;
import sk.management.ManagementInfo;
import sk.memberPrivate.PrivateDao;
import sk.memberPrivate.PrivateInfo;

public class PrivateInfoAction implements CommandAction{
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		HttpSession session = request.getSession();
		Integer worker_number = (Integer) session.getAttribute("worker_number");
		
		
		PrivateDao data = new PrivateDao();
		ManagementDao data2 = new ManagementDao();
		
		if(worker_number != null) {
			PrivateInfo privacy = data.getPrivate(worker_number);
			ManagementInfo management = data2.getManagement(worker_number);
			session.setAttribute("privacy", privacy);
			session.setAttribute("management", management);
		}
		return "/sk_user/member_info.jsp";
	}

}
