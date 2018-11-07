package sk.memberPrivate.action;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import sk.memberPrivate.PrivateInfo;

public class CommonPrivateAc {
	public PrivateInfo MappingreqPrivate(HttpServletRequest request) {
		PrivateInfo privacy = new PrivateInfo();
		Enumeration<String> parameterNames = request.getParameterNames();
		
		while(parameterNames.hasMoreElements()) {
			String paramName = (String) parameterNames.nextElement();
			switch(paramName) {
			case "worker_number":
				privacy.setWorker_number(Integer.parseInt(request.getParameter("worker_number")));
				break;
			case "name":
				privacy.setName(request.getParameter("name"));
				break;
			case "pass":
				privacy.setPass(request.getParameter("pass"));
				break;
			case "phone":
				privacy.setPhone(request.getParameter("phone"));
				break;
			case "phone2":
				privacy.setPhone2(request.getParameter("phone2"));
				break;
			case "e_mail":
				privacy.setE_mail(request.getParameter("e_mail"));
				break;
			case "address":
				privacy.setAddress(request.getParameter("address"));
				break;
			}
		}
		
		return privacy;
	}

}
