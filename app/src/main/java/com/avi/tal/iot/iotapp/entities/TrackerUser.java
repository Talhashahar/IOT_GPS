package com.avi.tal.iot.iotapp.entities;

import android.os.Parcel;
import android.os.Parcelable;

public class TrackerUser implements Parcelable {
    private String displayName;
    private Location location;
    private float maxLight;

    public TrackerUser() {
    }

    public TrackerUser(String displayName, float maxLight) {
        this.displayName = displayName;
        this.maxLight = maxLight;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public float getMaxLight() {
        return maxLight;
    }

    public void setMaxLight(float maxLight) {
        this.maxLight = maxLight;
    }

    protected TrackerUser(Parcel in) {
        displayName = in.readString();
        location = (Location) in.readValue(Location.class.getClassLoader());
        maxLight = in.readFloat();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(displayName);
        dest.writeValue(location);
        dest.writeFloat(maxLight);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<TrackerUser> CREATOR = new Parcelable.Creator<TrackerUser>() {
        @Override
        public TrackerUser createFromParcel(Parcel in) {
            return new TrackerUser(in);
        }

        @Override
        public TrackerUser[] newArray(int size) {
            return new TrackerUser[size];
        }
    };

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof TrackerUser) {
            return ((TrackerUser) obj).getDisplayName().equals(this.displayName);
        } else {
            return super.equals(obj);
        }
    }
}