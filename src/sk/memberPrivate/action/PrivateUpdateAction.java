package sk.memberPrivate.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.controller.CommandAction;
import sk.management.ManagementInfo;
import sk.management.action.CommonManagementAc;
import sk.memberPrivate.PrivateDao;
import sk.memberPrivate.PrivateInfo;
import sk.update.InsertUpdateDao;
import sk.update.InsertUpdateInfo;
import sk.update.action.CommonUpdateAction;

public class PrivateUpdateAction implements CommandAction {
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("utf-8");

		CommonPrivateAc utils = new CommonPrivateAc();
		PrivateInfo privacy = utils.MappingreqPrivate(request);

		PrivateDao data = new PrivateDao();
		String text = "";
		int change_private_num = 0;

		HttpSession session = request.getSession();
		Integer worker_number = (Integer)session.getAttribute("worker_number");
		
		if (worker_number != null) {
			
			//기존의 정보와 수정된 정보를 비교한다. 
			InsertUpdateDao data2 = new InsertUpdateDao();
			InsertUpdateInfo update = new InsertUpdateInfo();
			CommonUpdateAction utils3 = new CommonUpdateAction();
			PrivateInfo old_private = data.getPrivate(worker_number);

			if (!old_private.getPhone().equals(privacy.getPhone())) {
				update = utils3.MappingPrivateUpdate("phone", old_private, privacy);
				data2.insertUpdate(update, worker_number);
				change_private_num += 1;
			}
			if (!old_private.getPhone2().equals(privacy.getPhone2())) {
				update = utils3.MappingPrivateUpdate("phone2", old_private, privacy);
				data2.insertUpdate(update, worker_number);
				change_private_num += 1;
			}
			if (!old_private.getE_mail().equals(privacy.getE_mail())) {
				update = utils3.MappingPrivateUpdate("e_mail", old_private, privacy);
				data2.insertUpdate(update, worker_number);
				change_private_num += 1;
			}
			if (!old_private.getAddress().equals(privacy.getAddress())) {
				update = utils3.MappingPrivateUpdate("address", old_private, privacy);
				data2.insertUpdate(update, worker_number);
				change_private_num += 1;
			}
			if(!old_private.getPass().equals(privacy.getPass())) {
				change_private_num += 1;
			}
			
			
			
			
			if(change_private_num > 0) {
			if (data.updateMember(privacy, worker_number) != 0) {
				text = "회원정보 수정에 성공하였습니다. ";
			} else {
				text = "회원정보 수정에 실패하였습니다.";
			}}
		} else {
			response.sendRedirect(request.getContextPath() + "/home.do");
			return null;

		}
		request.setAttribute("message", text);

		return "/sk_user/private_info.do";
	}

}
