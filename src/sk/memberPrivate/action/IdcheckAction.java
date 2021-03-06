
package sk.memberPrivate.action;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.controller.CommandAction;
import sk.management.ManagementDao;
import sk.memberPrivate.PrivateDao;

public class IdcheckAction implements CommandAction {
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("utf-8");

		ManagementDao data = new ManagementDao();
		PrivateDao data2 = new PrivateDao();
		String name = request.getParameter("name");
		Integer worker_number = Integer.parseInt(request.getParameter("worker_number"));
		String text = "";
		

		if (data.isManagement(worker_number, name)) {
			if(data2.siteMember(worker_number)) {
				text = "이미 가입한 회원입니다.";
			}else {
			text = "인증되었습니다";}
			response.setContentType("text/plain; charset=utf-8");
			response.getWriter().write(text);
		} else {
			text = "등록되지 않은 사원입니다. 사원번호와 이름을 확인해 주세요 ";
			response.setContentType("text/plain; charset=utf-8");
			response.getWriter().write(text);
			
		}
		return null;
		
		
	}
}
