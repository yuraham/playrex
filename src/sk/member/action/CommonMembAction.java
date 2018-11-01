package sk.member.action;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import sk.member.MemberInfo;

public class CommonMembAction {
	public MemberInfo MappingReqMember(HttpServletRequest request) throws Throwable{
	
		MemberInfo Member = new MemberInfo();
		Enumeration<String> parameterNames = request.getParameterNames();
		
		
	}
		
	

}
