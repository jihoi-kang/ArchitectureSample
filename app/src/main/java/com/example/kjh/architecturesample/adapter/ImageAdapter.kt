package com.example.kjh.architecturesample.adapter

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kjh.architecturesample.adapter.contract.ImageAdapterContract
import com.example.kjh.architecturesample.adapter.holder.ImageViewHolder
import com.example.kjh.architecturesample.data.ImageItem
import com.example.kjh.architecturesample.listener.OnItemClickListener

class ImageAdapter(val context: Context) : RecyclerView.Adapter<ImageViewHolder>(), ImageAdapterContract.View, ImageAdapterContract.Model {

    var imageList: ArrayList<ImageItem>? = null

    var onItemClickListener: OnItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            = ImageViewHolder(context, parent, onItemClickListener)

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        imageList?.get(position)?.let {
            holder?.onBind(it, position)
        }
    }

    override fun getItemCount() = imageList?.size ?: 0

    override fun notifyAdapter() {
        notifyDataSetChanged()
    }

    override fun addItems(imageList: ArrayList<ImageItem>) {
        this.imageList = imageList
    }

    override fun clearItem() {
        imageList?.clear()
    }

}