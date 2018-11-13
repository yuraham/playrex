package sk.memberPrivate.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.controller.CommandAction;
import sk.management.ManagementDao;
import sk.memberPrivate.PrivateDao;
import sk.memberPrivate.PrivateInfo;

public class RegisterPrivateAc implements CommandAction {
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("utf-8");
		
		CommonPrivateAc utils = new CommonPrivateAc();
		PrivateInfo privacy = utils.MappingreqPrivate(request);
		
		PrivateDao data = new PrivateDao();
		ManagementDao data2 = new ManagementDao();
		String text = "";
		
		//사원번호가 등록되어 있는지 확인한다. 		
		if(data2.isManagement(privacy.getWorker_number(), privacy.getName())) {
			if(data.insertPrivate(privacy) != 0) {
				HttpSession session = request.getSession(false);
				if(session != null) {session.invalidate();}
				
				session = request.getSession(true);
				//session.setAttribute("worker_number", privacy.getWorker_number());
				
				text = "회원가입에 성공하였습니다. ";
			}else {
				text = "회원가입에 실패하였습니다. 잠시 후 다시 시도해 주세요.";
			}
		
		}else {text = "등록되지 않은 사원번호 입니다.";}
		request.setAttribute("message", text);
		
	return "privateRegister.jsp";
	}

}
