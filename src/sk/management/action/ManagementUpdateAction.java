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
import sk.update.InsertUpdateDao;
import sk.update.InsertUpdateInfo;
import sk.update.action.CommonUpdateAction;

public class ManagementUpdateAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("utf-8");

		// 개인정보부터 담기
		CommonPrivateAc utils = new CommonPrivateAc();
		PrivateInfo new_privacy = utils.MappingreqPrivate(request);

		// 인사정보 담기
		CommonManagementAc utils2 = new CommonManagementAc();
		ManagementInfo new_management = utils2.MappingreqManagement(request);

		PrivateDao data = new PrivateDao();
		ManagementDao data2 = new ManagementDao();

		HttpSession session = request.getSession();
		String author = (String) session.getAttribute("author");
		Integer worker_number = Integer.parseInt(request.getParameter("worker_number"));
		String text = "";
		StringBuffer list = new StringBuffer();
		int change_manager_num = 0;
		int change_private_num = 0;

		// 기존정보와 바뀐정보의 값을 비교하기
		InsertUpdateDao data3 = new InsertUpdateDao();
		InsertUpdateInfo update = new InsertUpdateInfo();
		CommonUpdateAction utils3 = new CommonUpdateAction();

		if (data2.isManagement2(worker_number)) {// 사원등록이 되어 있다면 수정할수 있다.

			if (data.siteMember(worker_number)) { // 사이트 가입이 되어 있다면 수정할수 있다.

				// 개인정보 비교
				PrivateInfo old_private = data.getPrivate(worker_number);

				if (!old_private.getPhone().equals(new_privacy.getPhone())) {
					update = utils3.MappingPrivateUpdate("phone", old_private, new_privacy);
					data3.insertUpdate(update, worker_number);
					change_private_num += 1;
				}
				if (!old_private.getPhone2().equals(new_privacy.getPhone2())) {
					update = utils3.MappingPrivateUpdate("phone2", old_private, new_privacy);
					data3.insertUpdate(update, worker_number);
					change_private_num += 1;
				}
				if (!old_private.getE_mail().equals(new_privacy.getE_mail())) {
					update = utils3.MappingPrivateUpdate("e_mail", old_private, new_privacy);
					data3.insertUpdate(update, worker_number);
					change_private_num += 1;
				}
				if (!old_private.getAddress().equals(new_privacy.getAddress())) {
					update = utils3.MappingPrivateUpdate("address", old_private, new_privacy);
					data3.insertUpdate(update, worker_number);
					change_private_num += 1;
				}
			} else {
				list.append("(개인정보)사이트에 가입하지 않은 사원입니다.<br>");
			}

			// 인사정보 비교
			ManagementInfo old_management = data2.getManagement(worker_number);
			if (!old_management.getDivision().equals(new_management.getDivision())) {
				update = utils3.MappingMenagerUpdate("division", old_management, new_management);
				data3.insertUpdate(update, worker_number);
				change_manager_num += 1;
			}
			if (!old_management.getPosition().equals(new_management.getPosition())) {
				update = utils3.MappingMenagerUpdate("position", old_management, new_management);
				data3.insertUpdate(update, worker_number);
				change_manager_num += 1;
			}
			if (old_management.getLeave_date() != (new_management.getLeave_date())) {
				update = utils3.MappingMenagerUpdate("leave_date", old_management, new_management);
				data3.insertUpdate(update, worker_number);
				change_manager_num += 1;
			}
			if (!old_management.getActive().equals(new_management.getActive())) {
				update = utils3.MappingMenagerUpdate("active", old_management, new_management);
				data3.insertUpdate(update, worker_number);
				change_manager_num += 1;

			}
			if (!old_management.getMemo().equals(new_management.getMemo())) {
				update = utils3.MappingMenagerUpdate("memo", old_management, new_management);
				data3.insertUpdate(update, worker_number);
				change_manager_num += 1;
			}
		}

		if (author != null) {
			//
			if (change_manager_num > 0) {
				if (data2.updateMember(new_management, worker_number) != 0) {
					list.append("(인사정보)사원 정보 수정에 성공하였습니다.<br>");

				} else {
					list.append("(인사정보)사원정보 수정에 실패하였습니다. <br>");
					// 수정기록 다시 지우기
				}
			}

			if (change_private_num > 0) {
				if (data.updateMember(new_privacy, worker_number) != 0) {
					list.append("(개인정보)사원 정보 수정에 성공하였습니다.<br>");

				} else {
					list.append("(개인정보)사원정보 수정에 실패하였습니다.<br>");
				}

			}
			
			text = list.toString();
			response.setContentType("text/plain; charset=utf-8");
			response.getWriter().write(text);
		}

		return null;
	}

}
