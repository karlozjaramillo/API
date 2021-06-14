package com.cj.api.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Locations {
    @SerializedName("results")
    List<Location> locationList;

    public List<Location> getLocationList() {
        return locationList;
    }

    public void setLocationList(List<Location> locationList) {
        this.locationList = locationList;
    }
}
