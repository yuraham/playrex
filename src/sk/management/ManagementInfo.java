package sk.management;

import java.sql.Timestamp;

public class ManagementInfo {
	private Integer num;
	private Integer worker_number;
	private String division;
	private String position;
	private Timestamp join_date;
	private Timestamp leave_date;
	private Integer activate;
	
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public Integer getWorker_number() {
		return worker_number;
	}
	public void setWorker_number(Integer worker_number) {
		this.worker_number = worker_number;
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
	public Integer getActivate() {
		return activate;
	}
	public void setActivate(Integer activate) {
		this.activate = activate;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public Timestamp getUpdate_date() {
		return update_date;
	}
	public void setUpdate_date(Timestamp update_date) {
		this.update_date = update_date;
	}
	private String memo;
	private Timestamp update_date;
	

}
