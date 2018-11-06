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

public class ManagementUpdateAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("utf-8");

		// 개인정보부터 담기
		CommonPrivateAc utils = new CommonPrivateAc();
		PrivateInfo privacy = utils.MappingreqPrivate(request);

		// 인사정보 담기
		CommonManagementAc utils2 = new CommonManagementAc();
		ManagementInfo management = utils2.MappingreqManagement(request);

		PrivateDao data = new PrivateDao();
		ManagementDao data2 = new ManagementDao();
		HttpSession session = request.getSession();
		String author = (String) session.getAttribute("author");
		Integer worker_number = Integer.parseInt(request.getParameter("worker_number"));
		String text = "";
///////////////////////////////////////////////////에러 디버깅하기
		if (author != null) {
			if (data.updateMember(privacy, worker_number) != 0 || data2.updateMember(management, worker_number) != 0) {
				text = "사원 정보 수정에 성공하였습니다.";
				// 수정내역 기록하는 코드 추가되야함 .
			} else {
				text = "사원정보 수정에 실패하였습니다. ";
			}
		} else {

			response.sendRedirect(request.getContextPath() + "/choice.jsp");
			return null;
		}

		return null;
	}

}
