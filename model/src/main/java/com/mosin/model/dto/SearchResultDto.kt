package com.mosin.model.dto

import com.google.gson.annotations.SerializedName

class SearchResultDto(
    @SerializedName("text") val text: String?,
    @SerializedName("meanings") val meanings: List<MeaningsDto?>?
)