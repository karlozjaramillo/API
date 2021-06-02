package com.cj.api.ApiManager;

import com.cj.api.models.Character;
import com.cj.api.models.Characters;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Api {
    String BASE_URL = "https://rickandmortyapi.com/api/";

    @GET("character")
    Call<Characters> getCharacters();

    @GET("character/{id}")
    Call<Character> getCharacter(@Path("id") String id);
}
