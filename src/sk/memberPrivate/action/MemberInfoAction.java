package sk.memberPrivate.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.controller.CommandAction;
import sk.memberPrivate.PrivateDao;

public class MemberInfoAction implements CommandAction {
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// 삭제 보류
		
		
		return "choice.jsp";
	}

}
