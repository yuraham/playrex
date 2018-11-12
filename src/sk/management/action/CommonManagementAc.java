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
				if (request.getParameter("division").equals(null)) {
					Management.setDivision("신입");
				} else {

					Management.setDivision(request.getParameter("division"));
				}
				break;
			case "position":
				if (request.getParameter("position").equals(null)) {
					Management.setPosition("신입");
				} else {
					Management.setPosition(request.getParameter("position"));
				}
				break;
			case "active":
				Management.setActive(request.getParameter("active"));
				break;
			case "memo":
				if (request.getParameter("memo").equals(null)) {

					Management.setMemo("");
				} else {
					Management.setMemo(request.getParameter("memo"));
				}
				break;
			}

		}
		return Management;
	}

}
