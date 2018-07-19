package com.avi.tal.iot.iotapp.entities;

import android.os.Parcel;
import android.os.Parcelable;

public class Location implements Parcelable {
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

    protected Location(Parcel in) {
        lat = in.readString();
        lon = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(lat);
        dest.writeString(lon);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Location> CREATOR = new Parcelable.Creator<Location>() {
        @Override
        public Location createFromParcel(Parcel in) {
            return new Location(in);
        }

        @Override
        public Location[] newArray(int size) {
            return new Location[size];
        }
    };
}