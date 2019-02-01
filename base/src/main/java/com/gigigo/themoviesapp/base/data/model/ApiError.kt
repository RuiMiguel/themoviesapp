package com.gigigo.themoviesapp.base.data.model

import com.google.gson.annotations.SerializedName

data class ApiError(
    @SerializedName("status_message") val statusMessage: String? = "",
    val success: Boolean? = false,
    @SerializedName("status_code") val statusCode: Int? = -1
)