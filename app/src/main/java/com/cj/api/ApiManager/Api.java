package com.cj.api.ApiManager;

import com.cj.api.models.Civilization;
import com.cj.api.models.Civilizations;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {
    String BASE_URL = "https://age-of-empires-2-api.herokuapp.com/api/v1/";

    @GET("civilizations")
    Call<Civilizations> getCivilizations();
}
