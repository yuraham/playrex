package sk.management.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.controller.CommandAction;

public class ManagementInfoAc implements CommandAction  {
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		String rPath = request.getContextPath();
		HttpSession session = request.getSession();
		Integer worker_name = (Integer)session.getAttribute("worker_name");
		String author = (String)session.getAttribute("author");
		String text = null;
		
		if(worker_name != null || author != null ) {
			response.sendRedirect(rPath+"/sk_manager/management_main.jsp");
			return null;
		}else {
			text = "관리자 권한이 없습니다";
			request.setAttribute("message", text);
			
		}
		
		return "/choice.jsp";
	}

}
