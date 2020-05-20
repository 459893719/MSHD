package com.miaosha.demo.domain;

public class DisasterRequest {
	private String id;
	private String date;
	private String disaster_type;
	private String status;
	private String o_url;
	private String request_unit;
	
	public DisasterRequest() {}
	public DisasterRequest(String id, String date, String disaster_type, String status, String o_url,
			String request_unit) {
		this.id = id;
		this.date = date;
		this.disaster_type = disaster_type;
		this.status = status;
		this.o_url = o_url;
		this.request_unit = request_unit;
	}
	@Override
	public String toString() {
		return "DisasterRequest [id=" + id + ", date=" + date + ", disaster_type=" + disaster_type + ", status="
				+ status + ", o_url=" + o_url + ", request_unit=" + request_unit + "]";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getDisaster_type() {
		return disaster_type;
	}
	public void setDisaster_type(String disaster_type) {
		this.disaster_type = disaster_type;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getO_url() {
		return o_url;
	}
	public void setO_url(String o_url) {
		this.o_url = o_url;
	}
	public String getRequest_unit() {
		return request_unit;
	}
	public void setRequest_unit(String request_unit) {
		this.request_unit = request_unit;
	}
	
	
	
}
