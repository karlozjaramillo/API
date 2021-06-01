package com.cj.api.models;

import com.google.gson.annotations.SerializedName;

public class Character {
    @SerializedName("id")
    private String idCharacter;

    @SerializedName("name")
    private String nameCharacter;

    public String getidCharacter() {
        return idCharacter;
    }

    public void setidCharacter(String idCharacter) {
        this.idCharacter = idCharacter;
    }

    public String getnameCharacter() {
        return nameCharacter;
    }

    public void setnameCharacter(String nameCharacter) {
        this.nameCharacter = nameCharacter;
    }

    public Character(String idCharacter, String nameCharacter) {
        this.idCharacter = idCharacter;
        this.nameCharacter = nameCharacter;
    }
}
