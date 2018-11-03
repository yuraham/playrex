package sk.memberPrivate.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.controller.CommandAction;
import sk.memberPrivate.PrivateDao;
import sk.memberPrivate.PrivateInfo;

public class LoginAction implements CommandAction {
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("utf-8");
		
		PrivateDao data = new PrivateDao();
		
		Integer worker_number = Integer.parseInt(request.getParameter("worker_number"));
		String pass = request.getParameter("pass");
		String rPath = request.getContextPath();
		String text = null;
		
		//회원가입이 되어잇다면
		if(data.isMember(worker_number, pass)) {
			HttpSession session = request.getSession();
			session.setAttribute("worker_number", worker_number);
			response.sendRedirect(rPath+"/choice.jsp");
			return null;
		}else {
			text = "입력내용을 다시 확인하여 주세요";
			request.setAttribute("message", text);
					
		}

		return "/index.jsp";
	}

}
