package com.example.andrew.zooapp.models;

/**
 * Created by Andrew on 20.11.2016.
 */

public class Pin {

    private String name;
    private double longitude;
    private double latitude;

    public Pin (String name, double longitude, double latitude) {

        this.name = name;
        this.longitude= longitude;
        this.latitude = latitude;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
