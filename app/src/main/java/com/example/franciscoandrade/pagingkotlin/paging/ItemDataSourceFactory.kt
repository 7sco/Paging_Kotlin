package com.example.franciscoandrade.pagingkotlin.paging

import android.arch.lifecycle.MutableLiveData
import android.arch.paging.DataSource
import android.arch.paging.PageKeyedDataSource
import com.example.franciscoandrade.pagingkotlin.model.Items

class ItemDataSourceFactory : DataSource.Factory<Int, Items> (){

    var itemLiveData: MutableLiveData<PageKeyedDataSource<Int, Items>> = MutableLiveData()

    override fun create(): DataSource<Int, Items> {
        var itemDataSource: ItemDataSource= ItemDataSource()
        itemLiveData.postValue(itemDataSource)
        return itemDataSource
    }

    fun getItemLiveDataSource(): MutableLiveData<PageKeyedDataSource<Int, Items>>{
        return itemLiveData
    }
}