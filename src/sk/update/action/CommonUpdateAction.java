package sk.update.action;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import sk.management.ManagementInfo;
import sk.memberPrivate.PrivateInfo;
import sk.update.InsertUpdateInfo;

public class CommonUpdateAction {
	public InsertUpdateInfo MappingreqUpdate(HttpServletRequest request) {
		InsertUpdateInfo update = new InsertUpdateInfo();
		Enumeration<String> parameterNames = request.getParameterNames();
		
		while(parameterNames.hasMoreElements()) {
			String paramName=(String) parameterNames.nextElement();
			switch(paramName) {
			case "num":
				update.setNum(Integer.parseInt(request.getParameter("num")));
				break;
			case "worker_number":
				update.setWorker_number(Integer.parseInt(request.getParameter("worker_number")));
				break;
			case "category":
				update.setCategory(request.getParameter("category"));
				break;
			case "filed_name":
				update.setCategory(request.getParameter("filed_name"));
				break;
			case "old_data":
				update.setCategory(request.getParameter("old_data"));
				break;
			case "new_data":
				update.setCategory(request.getParameter("new_data"));
				break;
			}
		}
		return update;
	}
	
	public InsertUpdateInfo MappingMenagerUpdate(String str, ManagementInfo old_data, ManagementInfo new_data) {
		InsertUpdateInfo update = new InsertUpdateInfo();
		
			switch(str) {
			case "active":
				update.setCategory("인사정보");
				update.setFiled_name("재직여부");
				update.setOld_data(old_data.getActive());
				update.setNew_data(new_data.getActive());
				break;
			case "division":
				update.setCategory("인사정보");
				update.setFiled_name("부서");
				update.setOld_data(old_data.getDivision());
				update.setNew_data(new_data.getDivision());
				break;
			case "position":
				update.setCategory("인사정보");
				update.setFiled_name("직책");
				update.setOld_data(old_data.getPosition());
				update.setNew_data(new_data.getPosition());
				break;
			case "leave_date":
				update.setCategory("인사정보");
				update.setFiled_name("퇴사일");
				update.setOld_data(old_data.getLeave_date().toString());
				update.setNew_data(new_data.getLeave_date().toString());
				break;
			case "memo":
				update.setCategory("인사정보");
				update.setFiled_name("메모");
				update.setOld_data(old_data.getMemo());
				update.setNew_data(new_data.getMemo());
				break;

		}
		return update;
	}
	
	public InsertUpdateInfo MappingPrivateUpdate(String str, PrivateInfo old_data, PrivateInfo new_data) {
		InsertUpdateInfo update = new InsertUpdateInfo();
		
			switch(str) {
			case "pass":
				update.setCategory("개인정보");
				update.setFiled_name("비밀번호");
				update.setOld_data(old_data.getPass());
				update.setNew_data(new_data.getPass());
				break;
			case "phone":
				update.setCategory("개인정보");
				update.setFiled_name("연락처");
				update.setOld_data(old_data.getPhone());
				update.setNew_data(new_data.getPhone());
				break;
			case "phone2":
				update.setCategory("개인정보");
				update.setFiled_name("자택");
				update.setOld_data(old_data.getPhone2());
				update.setNew_data(new_data.getPhone2());
				break;
			case "e_mail":
				update.setCategory("개인정보");
				update.setFiled_name("이메일");
				update.setOld_data(old_data.getE_mail());
				update.setNew_data(new_data.getE_mail());
				break;
			case "address":
				update.setCategory("개인정보");
				update.setFiled_name("주소");
				update.setOld_data(old_data.getAddress());
				update.setNew_data(new_data.getAddress());
				break;

		}
		return update;
	}

}
