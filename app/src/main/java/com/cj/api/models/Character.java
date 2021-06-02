package com.cj.api.models;

import com.google.gson.annotations.SerializedName;

public class Character {
    @SerializedName("id")
    private String idCharacter;

    @SerializedName("name")
    private String nameCharacter;

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

    public Character(String idCharacter, String nameCharacter) {
        this.idCharacter = idCharacter;
        this.nameCharacter = nameCharacter;
    }
}
