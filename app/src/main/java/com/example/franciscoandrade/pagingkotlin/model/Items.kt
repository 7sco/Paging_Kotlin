package com.example.franciscoandrade.pagingkotlin.model

import com.google.gson.annotations.SerializedName

data class Items(
        @SerializedName("owner")
        var owner: Owner,
        @SerializedName("is_accepted")
        var isAccepted: Boolean,
        @SerializedName("score")
        var score: Int,
        @SerializedName("last_activity_date")
        var lastActivityDate: Int,
        @SerializedName("last_edit_date")
        var lastEditDate: Int,
        @SerializedName("creation_date")
        var creationDate: Int,
        @SerializedName("answer_id")
        var answerId: Int,
        @SerializedName("question_id")
        var questionId: Int)