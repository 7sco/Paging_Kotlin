package com.example.franciscoandrade.pagingkotlin.paging

import android.arch.paging.PageKeyedDataSource
import com.example.franciscoandrade.pagingkotlin.api.RetrofitClient
import com.example.franciscoandrade.pagingkotlin.model.DataSourceApi
import com.example.franciscoandrade.pagingkotlin.model.Items
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class ItemDataSource : PageKeyedDataSource<Int, Items>() {

    companion object {
        const val PAGE_SIZE= 50
        const val FIRST_PAGE= 1
        const val SITE_NAME= "stackoverflow"
    }


    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, Items>) {
        RetrofitClient.mInstance
                .getApi().getAnswers(FIRST_PAGE, PAGE_SIZE, SITE_NAME)
                .enqueue(object : Callback<DataSourceApi> {
                    override fun onFailure(call: Call<DataSourceApi>, t: Throwable) {

                    }

                    override fun onResponse(call: Call<DataSourceApi>, response: Response<DataSourceApi>) {
                        if (response.body() != null){
                            callback.onResult(response.body()!!.items, null, FIRST_PAGE+1)
                        }
                    }
                })

    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Items>) {
        RetrofitClient.mInstance
                .getApi().getAnswers(params.key, PAGE_SIZE, SITE_NAME)
                .enqueue(object : Callback<DataSourceApi> {
                    override fun onFailure(call: Call<DataSourceApi>, t: Throwable) {

                    }

                    override fun onResponse(call: Call<DataSourceApi>, response: Response<DataSourceApi>) {
                        var adjacentKey: Int?=0
                        if (params.key>1){
                            adjacentKey= params.key-1
                        }
                        if (response.body() != null){
                            callback.onResult(response.body()!!.items, adjacentKey)
                        }
                    }
                })
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Items>) {
        RetrofitClient.mInstance
                .getApi().getAnswers(FIRST_PAGE, PAGE_SIZE, SITE_NAME)
                .enqueue(object : Callback<DataSourceApi> {
                    override fun onFailure(call: Call<DataSourceApi>, t: Throwable) {

                    }

                    override fun onResponse(call: Call<DataSourceApi>, response: Response<DataSourceApi>) {
                        //var adjacentKey = params.key>1 ? params.key-1:null
                        if(response.body()!= null && response.body()!!.has_more){
                            callback.onResult(response.body()!!.items, params.key+1)
                        }

                    }
                })
    }
}