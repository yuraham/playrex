package sk.management.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.controller.CommandAction;
import sk.management.ManagementDao;
import sk.management.ManagementInfo;

public class SearchAction implements CommandAction{
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// 이름으로 검색하여 사원리스트 가져오는 코드 작성하기
		request.setCharacterEncoding("utf-8");
		
		ManagementDao data = new ManagementDao();
		String rPath = request.getContextPath();
		String name = request.getParameter("name");
		ManagementInfo management = new ManagementInfo();
		int i = 0;
		StringBuffer list = new StringBuffer();
		
		for(i=1; i<30; i++) {
			management = data.getList(name, i);
			if(management.getName() != null) {
			list.append("<tr><td>");
			list.append("<a href=\"");
			list.append(rPath +"/sk_manager/detail.do?num="+i);
			list.append("\">");
			list.append(management.getWorker_number());
			list.append("</a>");
			list.append("</td><td>");
			list.append("<a href=\"");
			list.append(rPath +"/sk_manager/detail.do?num="+i);
			list.append("\">");
			list.append(management.getName());
			list.append("</a>");
			list.append("</td></tr>");
			}
		}
		request.setAttribute("memberList", list);
		
		return "management_main.jsp";
	}

}
