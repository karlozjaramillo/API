package com.cj.api.ApiManager;

import com.cj.api.models.Character;
import com.cj.api.models.Characters;
import com.cj.api.models.Episode;
import com.cj.api.models.Episodes;
import com.cj.api.models.Location;
import com.cj.api.models.Locations;

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

    @GET("episode")
    Call<Episodes> getEpisodes();

    @GET("episode/{id}")
    Call<Episode> getEpisode(@Path("id") String id);

    @GET("location")
    Call<Locations> getLocations();

    @GET("location/{id}")
    Call<Location> getLocation(@Path("id") String id);
}
