package sk.member;

import java.sql.Timestamp;

public class MemberInfo {
	private Integer worker_number;
	private String name;
	private String pass;
	private String authority;
	private Timestamp reg_date;
	
	public Integer getWorker_number() {
		return worker_number;
	}
	public void setWorker_number(Integer worker_number) {
		this.worker_number = worker_number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	public Timestamp getReg_date() {
		return reg_date;
	}
	public void setReg_date(Timestamp reg_date) {
		this.reg_date = reg_date;
	}
	
	
	
	

}
