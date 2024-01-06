package com.android.maplemate.Data


import com.google.gson.annotations.SerializedName

data class Union(
    @SerializedName("date")
    val date: String?,
    @SerializedName("union_grade")
    val unionGrade: String?,
    @SerializedName("union_level")
    val unionLevel: Int?
)