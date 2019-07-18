package com.example.kjh.architecturesample.adapter

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kjh.architecturesample.adapter.contract.ImageAdapterContract
import com.example.kjh.architecturesample.adapter.holder.ImageViewHolder
import com.example.kjh.architecturesample.data.ImageItem

class ImageAdapter(val context: Context) : RecyclerView.Adapter<ImageViewHolder>(), ImageAdapterContract.View, ImageAdapterContract.Model {

    private lateinit var imageList: ArrayList<ImageItem>

    override var onClickFunc: ((Int) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            = ImageViewHolder(context, parent, onClickFunc)

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        imageList?.get(position)?.let {
            holder?.onBind(it, position)
        }
    }

    override fun getItemCount() = imageList.size

    override fun notifyAdapter() {
        notifyDataSetChanged()
    }

    override fun addItems(imageList: ArrayList<ImageItem>) {
        this.imageList = imageList
    }

    override fun getItem(position: Int) = imageList[position]

    override fun clearItem() {
        imageList?.clear()
    }

}