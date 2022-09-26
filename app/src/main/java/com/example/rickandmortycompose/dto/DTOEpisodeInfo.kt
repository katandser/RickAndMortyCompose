package com.example.rickandmorty.dto

import com.google.gson.annotations.SerializedName

data class DTOEpisodeInfo(
    val id : Int,
    val name : String,
    @SerializedName("air_date") val airDate : String,
    private val episode : String,
    val characters : List<String>
) {
    val season = {
        episode.replace("S", "").split("E")[0]
    }

    val chapter = {
        episode.replace("S", "").split("E")[1]
    }
}
