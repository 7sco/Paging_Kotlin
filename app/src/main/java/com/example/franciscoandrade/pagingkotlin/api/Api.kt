package com.example.franciscoandrade.pagingkotlin.api


import com.example.franciscoandrade.pagingkotlin.model.DataSourceApi
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface Api {
    @GET("answers")
    fun getAnswers(@Query("page")page:Int,
                   @Query("pagesize")pagesize:Int,
                   @Query("site")site:String)
            :Call<DataSourceApi>
}


//@GET("api.php")
//fun hitCountCheck(@Query("action") action: String,
//                  @Query("format") format: String,
//                  @Query("list") list: String,
//                  @Query("srsearch") srsearch: String):
//        Observable<Model.Result>