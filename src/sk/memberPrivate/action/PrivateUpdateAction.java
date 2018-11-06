package sk.memberPrivate.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.controller.CommandAction;
import sk.management.ManagementInfo;
import sk.management.action.CommonManagementAc;
import sk.memberPrivate.PrivateDao;
import sk.memberPrivate.PrivateInfo;

public class PrivateUpdateAction implements CommandAction {
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("utf-8");

		CommonPrivateAc utils = new CommonPrivateAc();
		PrivateInfo privacy = utils.MappingreqPrivate(request);

		PrivateDao data = new PrivateDao();
		String text = "";

		HttpSession session = request.getSession();
		Integer worker_number = (Integer)session.getAttribute("worker_number");
		
		if (worker_number != null) {
			if (data.updateMember(privacy, worker_number) != 0) {
				text = "회원정보 수정에 성공하였습니다. ";
			} else {
				text = "회원정보 수정에 실패하였습니다.";
			}
		} else {
			response.sendRedirect(request.getContextPath() + "/home.do");
			return null;

		}
		request.setAttribute("message", text);

		return "/sk_user/private_info.do";
	}

}
