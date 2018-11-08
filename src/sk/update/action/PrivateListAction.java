package sk.update.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.controller.CommandAction;
import sk.management.ManagementInfo;
import sk.update.InsertUpdateDao;
import sk.update.InsertUpdateInfo;

public class PrivateListAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		HttpSession session = request.getSession();

		InsertUpdateDao data = new InsertUpdateDao();
		InsertUpdateInfo update = new InsertUpdateInfo();
		StringBuffer list = new StringBuffer();

		ManagementInfo management = (ManagementInfo) session.getAttribute("management");
		Integer worker_number = management.getWorker_number();

		int lastNum = data.getLastNum("개인정보"); // 제일 최근 수정된 내역의 번호
		for (int i = lastNum; i > lastNum - 15; i--) {
			if (data.isNumPrivate(i)) {
				update = data.getList(worker_number, "개인정보", i);

				list.append("<tr><td>");
				list.append(update.getWorker_number());
				list.append("</td><td>");
				list.append(update.getFiled_name());
				list.append("</td><td>");
				list.append(update.getOld_data());
				list.append("</td><td>");
				list.append(update.getNew_data());
				list.append("</td><td>");
				list.append(update.getUpdate_date());
				list.append("</td></tr>");
			}

		}

		session.setAttribute("changeList", list);

		return "/sk_manager/update_list.jsp";
	}
}
