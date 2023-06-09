package com.bangkit2023.capstone.greenix.data.response

import com.google.gson.annotations.SerializedName

data class Responses(
    @field:SerializedName("error")
    val error: Boolean,

    @field:SerializedName("message")
    val message: String
)
