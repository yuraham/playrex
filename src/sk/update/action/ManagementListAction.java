package sk.update.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.controller.CommandAction;
import sk.management.ManagementInfo;
import sk.update.InsertUpdateDao;
import sk.update.InsertUpdateInfo;

public class ManagementListAction implements CommandAction{
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		HttpSession session = request.getSession();
		
		InsertUpdateDao data = new InsertUpdateDao();
		InsertUpdateInfo update = new InsertUpdateInfo();
		
		ManagementInfo management = (ManagementInfo) session.getAttribute("management");
		Integer worker_number = management.getWorker_number();
		
		update = data.getList(worker_number, "인사정보");
		session.setAttribute("changeList", update);
		
		return "/sk_manager/management_list.jsp";
	}

}
