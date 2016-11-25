package com.example.andrew.zooapp.models;

/**
 * Created by Andrew on 25.11.2016.
 */

public class WorkingHours {

    private String days;
    private String time;
    private String cass_time;
    private String tech_break;
    private String expositions;
    private String image;

    public  WorkingHours (String days, String time, String cass_time, String tech_break, String expositions, String image){

        this.days = days;
        this.time = time;
        this.cass_time = cass_time;
        this.tech_break = tech_break;
        this.expositions = expositions;
        this.image = image;

    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getCass_time() {
        return cass_time;
    }

    public void setCass_time(String cass_time) {
        this.cass_time = cass_time;
    }

    public String getTech_break() {
        return tech_break;
    }

    public void setTech_break(String tech_break) {
        this.tech_break = tech_break;
    }

    public String getExpositions() {
        return expositions;
    }

    public void setExpositions(String expositions) {
        this.expositions = expositions;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
