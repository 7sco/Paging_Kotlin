package com.example.franciscoandrade.pagingkotlin.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {

    companion object {
        const val BASE_URL = "https://api.stackexchange.com/2.2/"
        var mInstance : RetrofitClient= RetrofitClient()
        lateinit var retrofit: Retrofit

    }


    constructor(){
        retrofit= Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }


    fun getApi():Api{
        return retrofit.create(Api::class.java)
    }

}