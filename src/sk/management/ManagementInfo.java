package sk.management;

import java.sql.Timestamp;

public class ManagementInfo {
	private Integer worker_number;
	private String name;
	private String division;
	private String position;
	private Timestamp join_date;
	private Timestamp leave_date;
	private Integer active;
	private String memo;
	private String authority;
	
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
	public String getDivision() {
		return division;
	}
	public void setDivision(String division) {
		this.division = division;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public Timestamp getJoin_date() {
		return join_date;
	}
	public void setJoin_date(Timestamp join_date) {
		this.join_date = join_date;
	}
	public Timestamp getLeave_date() {
		return leave_date;
	}
	public void setLeave_date(Timestamp leave_date) {
		this.leave_date = leave_date;
	}
	public Integer getActive() {
		return active;
	}
	public void setActive(Integer active) {
		this.active = active;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	
	

}
