package com.miaosha.demo.domain;

public class CollapseRecord {
	private String key;
	private String id;
	private String location;
	private String date;
	private String type;
	private String status;
	private String note;
	private String picture;
	private String reporting_unit;
	
	public CollapseRecord() {}

	public CollapseRecord(String key, String id, String location, String date, String type, String status, String note,
			String picture, String reporting_unit) {
		this.key = key;
		this.id = id;
		this.location = location;
		this.date = date;
		this.type = type;
		this.status = status;
		this.note = note;
		this.picture = picture;
		this.reporting_unit = reporting_unit;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	@Override
	public String toString() {
		return "CollapseRecord [key=" + key + ", id=" + id + ", location=" + location + ", date=" + date + ", type="
				+ type + ", status=" + status + ", note=" + note + ", picture=" + picture + ", reporting_unit="
				+ reporting_unit + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getReporting_unit() {
		return reporting_unit;
	}

	public void setReporting_unit(String reporting_unit) {
		this.reporting_unit = reporting_unit;
	}
	
	
}
