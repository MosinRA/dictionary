package com.mosin.model.dto

import com.google.gson.annotations.SerializedName

class MeaningsDto(
    @SerializedName("translation") val translation: TranslationDto?,
    @SerializedName("imageUrl") val imageUrl: String?
)