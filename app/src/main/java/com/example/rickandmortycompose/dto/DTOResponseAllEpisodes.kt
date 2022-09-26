package com.example.rickandmorty.dto

data class DTOResponseAllEpisodes(
    val infoPage: DTOInfoPage,
    val result: List<DTOEpisodeInfo>
)
