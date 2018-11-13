package sk.management.action;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.controller.CommandAction;
import sk.management.ManagementDao;
import sk.management.ManagementInfo;
import sk.memberPrivate.PrivateDao;
import sk.memberPrivate.PrivateInfo;
import sk.memberPrivate.action.CommonPrivateAc;

public class DetailAction implements CommandAction {
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		HttpSession session = request.getSession();
		ManagementDao data = new ManagementDao();
		PrivateDao data2 = new PrivateDao();
		ManagementInfo management = new ManagementInfo();
		PrivateInfo privacy = new PrivateInfo();
		int number = Integer.parseInt(request.getParameter("num"));
		StringBuffer list = new StringBuffer();
		
		//사원등록을 확인한다. 
		if(data.isManagement2(number)) {
			management = data.getManagement(number);
			list.append(management.getWorker_number()+",");
			list.append(management.getName()+",");
			list.append(management.getDivision()+",");
			list.append(management.getPosition()+",");
			list.append(management.getJoin_date()+",");
			list.append(management.getLeave_date()+",");
			list.append(management.getActive()+",");
			list.append(management.getMemo()+",");
			list.append(management.getAuthority()+",");
			//리스트에 사원번호, 이름, 부서, 직책, 입사일, 퇴사일, 재직여부, 메모, 관리자 순으로 더한다.
		}
		
		if(data2.siteMember(number)) {
			privacy = data2.getPrivate(number);
			
		}else {
			privacy.setPhone("");
			privacy.setPhone2("");
			privacy.setE_mail("");
			privacy.setAddress("");
		}
		list.append(privacy.getPhone()+",");
		list.append(privacy.getPhone2()+",");
		list.append(privacy.getE_mail()+",");
		list.append(privacy.getAddress());
		//리스트에 핸드폰, 자택, 이메일, 주소  순으로 더한다. 
		
		String text = list.toString();
		response.setContentType("text/plain; charset=utf-8");
		response.getWriter().write(text);
		
		return null;
	}

}
