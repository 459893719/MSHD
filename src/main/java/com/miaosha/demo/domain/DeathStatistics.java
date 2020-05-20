package com.miaosha.demo.domain;

public class DeathStatistics {
	private String id;
	private String location;
	private String date;
	private String number;
	private String reporting_unit;
	
	public DeathStatistics() {}
	public DeathStatistics(String id, String location, String date, String number, String reporting_unit) {
		this.id = id;
		this.location = location;
		this.date = date;
		this.number = number;
		this.reporting_unit = reporting_unit;
	}
	@Override
	public String toString() {
		return "DeathStatistics [id=" + id + ", location=" + location + ", date=" + date + ", number=" + number
				+ ", reporting_unit=" + reporting_unit + "]";
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
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getReporting_unit() {
		return reporting_unit;
	}
	public void setReporting_unit(String reporting_unit) {
		this.reporting_unit = reporting_unit;
	}
	
	
}
