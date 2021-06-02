package com.cj.api.models;

import com.google.gson.annotations.SerializedName;

public class Character {
    @SerializedName("id")
    private String idCharacter;

    @SerializedName("name")
    private String nameCharacter;

    @SerializedName("image")
    private String imageCharacter;

    @SerializedName("status")
    private String statusCharacter;

    public String getStatusCharacter() {
        return statusCharacter;
    }

    public void setStatusCharacter(String statusCharacter) {
        this.statusCharacter = statusCharacter;
    }

    public String getSpeciesCharacter() {
        return speciesCharacter;
    }

    public void setSpeciesCharacter(String speciesCharacter) {
        this.speciesCharacter = speciesCharacter;
    }

    public String getGenderCharacter() {
        return genderCharacter;
    }

    public void setGenderCharacter(String genderCharacter) {
        this.genderCharacter = genderCharacter;
    }

    @SerializedName("species")
    private String speciesCharacter;

    @SerializedName("gender")
    private String genderCharacter;

    public String getImageCharacter() {
        return imageCharacter;
    }

    public void setImageCharacter(String imageCharacter) {
        this.imageCharacter = imageCharacter;
    }

    public String getIdCharacter() {
        return idCharacter;
    }

    public void setIdCharacter(String idCharacter) {
        this.idCharacter = idCharacter;
    }

    public String getNameCharacter() {
        return nameCharacter;
    }

    public void setNameCharacter(String nameCharacter) {
        this.nameCharacter = nameCharacter;
    }

    public Character(String idCharacter, String nameCharacter, String imageCharacter, String statusCharacter, String speciesCharacter, String genderCharacter) {
        this.idCharacter = idCharacter;
        this.nameCharacter = nameCharacter;
        this.imageCharacter = imageCharacter;
        this.statusCharacter = statusCharacter;
        this.speciesCharacter = speciesCharacter;
        this.genderCharacter = genderCharacter;
    }
}
