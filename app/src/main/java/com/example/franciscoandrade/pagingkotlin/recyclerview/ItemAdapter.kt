package com.example.franciscoandrade.pagingkotlin.recyclerview

import android.arch.paging.PagedListAdapter
import android.content.Context
import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.franciscoandrade.pagingkotlin.R
import com.example.franciscoandrade.pagingkotlin.model.Items
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.recyclerview_users.view.*

class ItemAdapter (): PagedListAdapter<Items, ItemAdapter.ItemViewHolder>(diffCallback) {

    private lateinit var mCtx: Context


    constructor(mCtx : Context) : this() {
        this.mCtx=mCtx
    }


    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ItemViewHolder {
        val view: View= LayoutInflater.from(mCtx).inflate(R.layout.recyclerview_users, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item:Items?= getItem(position)
        if (item != null){
            holder.itemView.textViewName.text= item.owner.displayName
            Glide.with(mCtx)
                    .load(item.owner.profileImage)
                    .into(holder.itemView.imageView)
        }else{
            Toast.makeText(mCtx, "Item is Null", Toast.LENGTH_LONG).show()
        }

    }


    companion object {
        /**
         * This diff callback informs the PagedListAdapter how to compute list differences when new
         * PagedLists arrive.
         * <p>
         * When you add a Cheese with the 'Add' button, the PagedListAdapter uses diffCallback to
         * detect there's only a single item difference from before, so it only needs to animate and
         * rebind a single view.
         *
         * @see android.support.v7.util.DiffUtil
         */
        private val diffCallback = object : DiffUtil.ItemCallback<Items>() {


            override fun areItemsTheSame(oldItem: Items, newItem: Items): Boolean =  oldItem.questionId == newItem.questionId

                    /**
                     * Note that in kotlin, == checking on data classes compares all contents, but in Java,
                     * typically you'll implement Object#equals, and use it to compare object contents.
                     */
                    override fun areContentsTheSame(oldItem: Items, newItem: Items): Boolean=oldItem == newItem

        }
    }

    class ItemViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        fun bindView(position: Int){

        }

    }
}