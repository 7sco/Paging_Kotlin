package com.example.franciscoandrade.pagingkotlin.model

import com.google.gson.annotations.SerializedName

data class Owner(
        @SerializedName("reputation")
        var reputation: Int,
        @SerializedName("user_id")
        var userId: Int,
        @SerializedName("user_type")
        val userType: String,
        @SerializedName("accept_rate")
        var acceptRate: Int,
        @SerializedName("profile_image")
        val profileImage: String,
        @SerializedName("display_name")
        val displayName: String,
        @SerializedName("link")
        val link: String)