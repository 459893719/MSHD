package com.miaosha.demo.domain;

public class Disaster {
    private String id;
    private String date;
    private String location;
    private String type;
    private String grade;
    private String picture;
    private String note;
    private String reporting_unit;

    public Disaster(){

    }
    public Disaster(String id, String date, String location, String type, String grade, String picture, String note, String reporting_unit) {
        this.id = id;
        this.date = date;
        this.location = location;
        this.type = type;
        this.grade = grade;
        this.picture = picture;
        this.note = note;
        this.reporting_unit = reporting_unit;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setReporting_unit(String reporting_unit) {
        this.reporting_unit = reporting_unit;
    }

    public String getId() {
        return id;
    }

    public String getDate() {
        return date;
    }
    public String getLocation() {
        return location;
    }

    public String getType() {
        return type;
    }

    public String getGrade() {
        return grade;
    }

    public String getPicture() {
        return picture;
    }

    public String getNote() {
        return note;
    }

    public String getReporting_unit() {
        return reporting_unit;
    }

    @Override
    public String toString() {
        return "Disaster{" +
                "id='" + id + '\'' +
                ", date='" + date + '\'' +
                ", location='" + location + '\'' +
                ", type='" + type + '\'' +
                ", grade='" + grade + '\'' +
                ", picture='" + picture + '\'' +
                ", note='" + note + '\'' +
                ", reporting_unit='" + reporting_unit + '\'' +
                '}';
    }
}
