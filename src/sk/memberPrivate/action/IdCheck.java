package sk.memberPrivate.action;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import member.controller.CommandAction;
import sk.management.ManagementDao;

public class IdCheck{
	public String idCheckText(HttpServletRequest request) throws UnsupportedEncodingException {
	request.setCharacterEncoding("utf-8");
	
	ManagementDao data = new ManagementDao();
	String name = (String)request.getParameter("name");
	Integer worker_number = Integer.parseInt(request.getParameter("worker_number"));
	String text = "";
	
	if(data.isManagement(worker_number, name)) {
		text = "인증되었습니다";
		
	}else {text = "등록되지 않은 사원입니다.";}
	
	
	return text;
	}
	
//@Override
//	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
//		request.setCharacterEncoding("utf-8");
//		
//		ManagementDao data = new ManagementDao();
//		String name = (String)request.getParameter("name");
//		Integer worker_number = Integer.parseInt(request.getParameter("worker_number"));
//		String text = "";
//		
//		if(data.isManagement(worker_number, name)) {
//			text = "인증되었습니다";
//			
//		}else {text = "등록되지 않은 사원입니다.";}
//
//		
//		return text;
//	}	
//	

}
