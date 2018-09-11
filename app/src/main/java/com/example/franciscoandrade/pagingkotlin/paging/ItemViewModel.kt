package com.example.franciscoandrade.pagingkotlin.paging

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import android.arch.paging.LivePagedListBuilder
import android.arch.paging.PageKeyedDataSource
import android.arch.paging.PagedList
import com.example.franciscoandrade.pagingkotlin.model.Items

class ItemViewModel: ViewModel() {

     var itemPagedList: LiveData<PagedList<Items>>
     var liveDataSource: LiveData<PageKeyedDataSource<Int, Items>>

    init {
        var  itemDataSourceFactory: ItemDataSourceFactory= ItemDataSourceFactory()
        liveDataSource = itemDataSourceFactory.getItemLiveDataSource()

        var  pagedListConfig: PagedList.Config=
                (PagedList.Config.Builder()).setEnablePlaceholders(false)
                        .setPageSize(ItemDataSource.PAGE_SIZE).build()

        itemPagedList=(LivePagedListBuilder(itemDataSourceFactory, pagedListConfig ))
                .build()
    }

}