package com.miaosha.demo.domain;

public class CivilStructure {
	private String key;
	private String id;
	private String date;
	private String location;
	private String basically_intact_square;
	private String damaged_square;
	private String destroyed_square;
	private String note;
	private String reporting_unit;
	
	public CivilStructure() {}

	public CivilStructure(String key, String id, String date, String location, String basically_intact_square,
			String damaged_square, String destroyed_square, String note, String reporting_unit) {
		this.key = key;
		this.id = id;
		this.date = date;
		this.location = location;
		this.basically_intact_square = basically_intact_square;
		this.damaged_square = damaged_square;
		this.destroyed_square = destroyed_square;
		this.note = note;
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
		return "CivilStructure [key=" + key + ", id=" + id + ", date=" + date + ", location=" + location
				+ ", basically_intact_square=" + basically_intact_square + ", damaged_square=" + damaged_square
				+ ", destroyed_square=" + destroyed_square + ", note=" + note + ", reporting_unit=" + reporting_unit
				+ "]";
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

	public String getBasically_intact_square() {
		return basically_intact_square;
	}

	public void setBasically_intact_square(String basically_intact_square) {
		this.basically_intact_square = basically_intact_square;
	}

	public String getDamaged_square() {
		return damaged_square;
	}

	public void setDamaged_square(String damaged_square) {
		this.damaged_square = damaged_square;
	}

	public String getDestroyed_square() {
		return destroyed_square;
	}

	public void setDestroyed_square(String destroyed_square) {
		this.destroyed_square = destroyed_square;
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
	
};

 