package com.example.franciscoandrade.pagingkotlin.model

class DataSourceApi (
        val items: List<Items>,
        val has_more: Boolean,
        val quota_max: Int,
        val quota_remaining: Int )