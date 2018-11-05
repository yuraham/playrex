package sk.memberPrivate.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.controller.CommandAction;

public class LogoutAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		HttpSession session = request.getSession();
		String name = (String)session.getAttribute("name");

		if (name != null) 
			session.invalidate();
		
		response.sendRedirect(request.getContextPath() + "/home.do");
		
		return null;

	}

}
