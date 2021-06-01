package com.cj.api.ApiManager;

import com.cj.api.models.Characters;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {
    String BASE_URL = "https://rickandmortyapi.com/api/";

    @GET("character")
    Call<Characters> getCharacters();
}
