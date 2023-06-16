package com.bangkit2023.capstone.greenix.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Article(
    val article: String,
    val description: String,
    val photo: String,
    val date: String
) : Parcelable