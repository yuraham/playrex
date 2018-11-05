package sk.memberPrivate.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.controller.CommandAction;
import sk.management.ManagementDao;
import sk.memberPrivate.PrivateDao;


public class LoginAction implements CommandAction {
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("utf-8");
		
		PrivateDao data = new PrivateDao();
		ManagementDao data2 = new ManagementDao();
		
		Integer worker_number = Integer.parseInt(request.getParameter("worker_number"));
		String pass = request.getParameter("pass");
		String rPath = request.getContextPath();
		String name = data2.getManagement(worker_number).getName();
		String text = null;
		
		//회원가입이 되어잇다면
		if(data.isMember(worker_number, pass)) {
			HttpSession session = request.getSession();
			session.setAttribute("worker_number", worker_number);
			session.setAttribute("name", name );
			response.sendRedirect(rPath+"/choice.jsp");
			return null;
		}else {
			text = "사원 번호와 비밀번호를 확인하여 주세요 ";
			request.setAttribute("message", text);
					
		}

		return "/index.jsp";
	}

}
