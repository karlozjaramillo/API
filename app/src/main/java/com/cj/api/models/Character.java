package com.cj.api.models;

import com.google.gson.annotations.SerializedName;

public class Character {
    @SerializedName("id")
    private String idCharacter;

    @SerializedName("name")
    private String nameCharacter;

    @SerializedName("image")
    private String imageCharacter;

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

    public Character(String idCharacter, String nameCharacter, String imageCharacter) {
        this.idCharacter = idCharacter;
        this.nameCharacter = nameCharacter;
        this.imageCharacter = imageCharacter;
    }
}
