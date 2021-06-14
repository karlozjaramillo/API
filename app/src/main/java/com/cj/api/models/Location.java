package com.cj.api.models;

import com.google.gson.annotations.SerializedName;

public class Location {
    @SerializedName("id")
    private String idLocation;

    @SerializedName("name")
    private String nameLocation;

    @SerializedName("type")
    private String typeLocation;

    @SerializedName("dimension")
    private String dimensionLocation;

    @SerializedName("created")
    private String createdLocation;

    public Location(String idLocation, String nameLocation, String typeLocation,
                    String dimensionLocation, String createdLocation) {
        this.idLocation = idLocation;
        this.nameLocation = nameLocation;
        this.typeLocation = typeLocation;
        this.dimensionLocation = dimensionLocation;
        this.createdLocation = createdLocation;
    }

    public String getIdLocation() {
        return idLocation;
    }

    public void setIdLocation(String idLocation) {
        this.idLocation = idLocation;
    }

    public String getNameLocation() {
        return nameLocation;
    }

    public void setNameLocation(String nameLocation) {
        this.nameLocation = nameLocation;
    }

    public String getTypeLocation() {
        return typeLocation;
    }

    public void setTypeLocation(String typeLocation) {
        this.typeLocation = typeLocation;
    }

    public String getDimensionLocation() {
        return dimensionLocation;
    }

    public void setDimensionLocation(String dimensionLocation) {
        this.dimensionLocation = dimensionLocation;
    }

    public String getCreatedLocation() {
        return createdLocation;
    }

    public void setCreatedLocation(String createdLocation) {
        this.createdLocation = createdLocation;
    }
}
