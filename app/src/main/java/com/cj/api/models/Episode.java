package com.cj.api.models;

import com.google.gson.annotations.SerializedName;

public class Episode {
    @SerializedName("id")
    private String idEpisode;

    @SerializedName("name")
    private String nameEpisode;

    @SerializedName("air_date")
    private String airDateEpisode;

    @SerializedName("episode")
    private String episodeEpisode;

    @SerializedName("created")
    private String createdEpisode;

    public Episode(String idEpisode, String nameEpisode, String airDateEpisode,
                   String episodeEpisode, String createdEpisode) {
        this.idEpisode = idEpisode;
        this.nameEpisode = nameEpisode;
        this.airDateEpisode = airDateEpisode;
        this.episodeEpisode = episodeEpisode;
        this.createdEpisode = createdEpisode;
    }

    public String getIdEpisode() {
        return idEpisode;
    }

    public void setIdEpisode(String idEpisode) {
        this.idEpisode = idEpisode;
    }

    public String getNameEpisode() {
        return nameEpisode;
    }

    public void setNameEpisode(String nameEpisode) {
        this.nameEpisode = nameEpisode;
    }

    public String getAirDateEpisode() {
        return airDateEpisode;
    }

    public void setAirDateEpisode(String airDateEpisode) {
        this.airDateEpisode = airDateEpisode;
    }

    public String getEpisodeEpisode() {
        return episodeEpisode;
    }

    public void setEpisodeEpisode(String episodeEpisode) {
        this.episodeEpisode = episodeEpisode;
    }

    public String getCreatedEpisode() {
        return createdEpisode;
    }

    public void setCreatedEpisode(String createdEpisode) {
        this.createdEpisode = createdEpisode;
    }
}
