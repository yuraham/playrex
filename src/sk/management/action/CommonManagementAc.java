package sk.management.action;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import sk.management.ManagementInfo;

public class CommonManagementAc {
	public ManagementInfo MappingreqManagement(HttpServletRequest request) throws Throwable {
		ManagementInfo Management = new ManagementInfo();
		Enumeration<String> parameterNames = request.getParameterNames();

		while (parameterNames.hasMoreElements()) {
			String paramName = (String) parameterNames.nextElement();
			switch (paramName) {
			case "name":
				Management.setName(request.getParameter("name"));
				break;
			case "division":
				
					Management.setDivision(request.getParameter("division"));
				
				break;
			case "position":
				
					Management.setPosition(request.getParameter("position"));
				
				break;
			case "memo":
				if (request.getParameter("memo").equals("")) {
					Management.setMemo(null);
				} else {
					Management.setMemo(request.getParameter("memo"));
				}
				break;
			}

		}
		return Management;
	}

}
