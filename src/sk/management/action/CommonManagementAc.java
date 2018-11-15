package sk.management.action;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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
				if (request.getParameter("division").equals("")) {
					Management.setDivision("신입");
				} else {

					Management.setDivision(request.getParameter("division"));
				}
				break;
			case "position":
				if (request.getParameter("position").equals("")) {
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
			case "leave_date":
				Timestamp dateTime;
				if (request.getParameter("leave_date").equals("")) {
					dateTime = null;
				} else {
					DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
					Date date = formatter.parse(request.getParameter("leave_date"));
					dateTime = new Timestamp(date.getTime());
				}

				Management.setLeave_date(dateTime);
				break;
			}

		}
		return Management;
	}

}
