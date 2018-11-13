package sk.management.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.controller.CommandAction;
import sk.management.ManagementDao;
import sk.management.ManagementInfo;

public class RegisterManagementAc implements CommandAction {
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("utf-8");
		
		CommonManagementAc utils = new CommonManagementAc();
		ManagementInfo management = utils.MappingreqManagement(request);
		
		ManagementDao data = new ManagementDao();
		String text = null;
		
		if(data.insertManagement(management) !=0) {
			text = "사원등록에 에 성공하였습니다.";
		}else {
			text = "사원등록에 실패하였습니다.";
		}
		response.setContentType("text/plain; charset=utf-8");
		response.getWriter().write(text);
		
		return null;
	}

}
