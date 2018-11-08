package yr.meeting;

import java.sql.Timestamp;

public class MeetingInfo {
	private int met_numb;
	private String met_title;
	private String met_room;
	private String met_project;
	private String met_subject;
	private String met_text;
	private Timestamp met_date;
	private int met_writer;
	
	public int getMet_numb() {
		return met_numb;
	}
	
	public void setMet_numb(int met_numb) {
		this.met_numb = met_numb;
	}
	public String getMet_title() {
		return met_title;
	}
	public void setMet_title(String met_title) {
		this.met_title = met_title;
	}
	public String getMet_room() {
		return met_room;
	}
	public void setMet_room(String met_room) {
		this.met_room = met_room;
	}
	public String getMet_project() {
		return met_project;
	}
	public void setMet_project(String met_project) {
		this.met_project = met_project;
	}
	public String getMet_subject() {
		return met_subject;
	}
	public void setMet_subject(String met_subject) {
		this.met_subject = met_subject;
	}
	public String getMet_text() {
		return met_text;
	}
	public void setMet_text(String met_text) {
		this.met_text = met_text;
	}
	public Timestamp getMet_date() {
		return met_date;
	}
	public void setMet_date(Timestamp met_date) {
		this.met_date = met_date;
	}
	public int getMet_writer() {
		return met_writer;
	}
	public void setMet_writer(int met_writer) {
		this.met_writer = met_writer;
	}
	
}
