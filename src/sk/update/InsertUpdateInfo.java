package sk.update;

import java.sql.Timestamp;

public class InsertUpdateInfo {
	private Integer num;
	private Integer worker_number;
	private String category;
	private String filed_name;
	private String old_data;
	private String new_data;
	private Timestamp update_date;
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
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getFiled_name() {
		return filed_name;
	}
	public void setFiled_name(String filed_name) {
		this.filed_name = filed_name;
	}
	public String getOld_data() {
		return old_data;
	}
	public void setOld_data(String old_data) {
		this.old_data = old_data;
	}
	public String getNew_data() {
		return new_data;
	}
	public void setNew_data(String new_data) {
		this.new_data = new_data;
	}
	public Timestamp getUpdate_date() {
		return update_date;
	}
	public void setUpdate_date(Timestamp update_date) {
		this.update_date = update_date;
	}

}
