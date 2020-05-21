package com.miaosha.demo.domain;

public class DisasterPrediction {
	private String key;
	private String id;
	private String date;
	private String location;
	private String longitude;
	private String latitude;
	private String depth;
	private String magnitude;
	private String intensity;
	private String type;
	private String picture;
	private String note;
	private String reporting_unit;
	
	public DisasterPrediction() {}
	public DisasterPrediction(String key, String id, String date, String location, String longitude, String latitude, String depth,
			String magnitude, String intensity, String type, String picture, String note, String reporting_unit) {
		this.key = key;
		this.id = id;
		this.date = date;
		this.location = location;
		this.longitude = longitude;
		this.latitude = latitude;
		this.depth = depth;
		this.magnitude = magnitude;
		this.intensity = intensity;
		this.type = type;
		this.picture = picture;
		this.note = note;
		this.reporting_unit = reporting_unit;
	}
	@Override
	public String toString() {
		return "DisasterPrediction [key=" + key + ", id=" + id + ", date=" + date + ", location=" + location
				+ ", longitude=" + longitude + ", latitude=" + latitude + ", depth=" + depth + ", magnitude="
				+ magnitude + ", intensity=" + intensity + ", type=" + type + ", picture=" + picture + ", note=" + note
				+ ", reporting_unit=" + reporting_unit + "]";
	}
	
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
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
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getDepth() {
		return depth;
	}
	public void setDepth(String depth) {
		this.depth = depth;
	}
	public String getMagnitude() {
		return magnitude;
	}
	public void setMagnitude(String magnitude) {
		this.magnitude = magnitude;
	}
	public String getIntensity() {
		return intensity;
	}
	public void setIntensity(String intensity) {
		this.intensity = intensity;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getReporting_unit() {
		return reporting_unit;
	}
	public void setReporting_unit(String reporting_unit) {
		this.reporting_unit = reporting_unit;
	}
	
	
}
