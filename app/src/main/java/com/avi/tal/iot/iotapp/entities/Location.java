package com.avi.tal.iot.iotapp.entities;

public class Location {
    private String lat;
    private String lon;

    public Location() {
    }

    public Location(String lat, String lon) {
        this.lat = lat;
        this.lon = lon;
    }

    public String getLat() {
        return lat;
    }

    public Float getLatFloat(){
        return Float.parseFloat(lat);
    }

    public Float getLonFloat(){
        return Float.parseFloat(lon);
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }
}
