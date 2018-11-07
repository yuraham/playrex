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
		
		//////이름으로 검색하여 사번을 알아낸다. 사번을 리스트로 관리하여  리스트를 포문으로 돌린다.
		for(i=1; i<30; i++) {
		if(	data.isManagement2(i) ) {
			if(data.getManagement(i).getName().equals(name)) {
			 
			management = data.getList(name, i);
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
		}
		
		request.setAttribute("memberList", list);
		
		return "management_main.jsp";
	}

}