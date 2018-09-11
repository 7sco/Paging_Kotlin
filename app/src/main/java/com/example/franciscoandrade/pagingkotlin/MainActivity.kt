package com.example.franciscoandrade.pagingkotlin

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.arch.paging.PagedList
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.franciscoandrade.pagingkotlin.model.Items
import com.example.franciscoandrade.pagingkotlin.paging.ItemViewModel
import com.example.franciscoandrade.pagingkotlin.recyclerview.ItemAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var itemViewModel = ViewModelProviders.of(this).get(ItemViewModel::class.java)
        val adapter: ItemAdapter= ItemAdapter(this)

        itemViewModel.itemPagedList.observe(this, Observer<PagedList<Items>>() {
            adapter.submitList(it)
        })

        recyclerView.adapter=adapter
    }
}
