package com.cj.api.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Characters {
    @SerializedName("results")
    List<Character> characterList;

    public List<Character> getCharacterList() {
        return characterList;
    }

    public void setCharacterList(List<Character> characterList){
        this.characterList = characterList;
    }
}
