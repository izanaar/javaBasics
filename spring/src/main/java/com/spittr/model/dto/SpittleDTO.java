package com.spittr.model.dto;

import com.spittr.model.Spittle;

import java.util.Date;

public class SpittleDTO {
    private String message;
    private Date time;
    private double longitude;
    private double latitude;

    public SpittleDTO() {
    }

    public Spittle toSpittle(){
        return new Spittle(null, message, time, longitude, latitude);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = new Date(time);
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
}
