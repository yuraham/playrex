package sk.management.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.controller.CommandAction;
import sk.management.ManagementDao;
import sk.management.ManagementInfo;
import sk.memberPrivate.PrivateDao;
import sk.memberPrivate.PrivateInfo;

public class DetailAction implements CommandAction {
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		HttpSession session = request.getSession();
		ManagementDao data = new ManagementDao();
		PrivateDao data2 = new PrivateDao();
		ManagementInfo management = new ManagementInfo();
		PrivateInfo privacy = new PrivateInfo();
		int number = Integer.parseInt(request.getParameter("num"));
		
		management = data.getManagement(number);
		privacy = data2.getPrivate(number);
		
		session.setAttribute("management", management);
		session.setAttribute("privacy", privacy);
		
		
		return "management_main.jsp";
	}

}
