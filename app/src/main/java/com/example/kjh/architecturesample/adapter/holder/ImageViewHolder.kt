package com.example.kjh.architecturesample.adapter.holder

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kjh.architecturesample.R
import com.example.kjh.architecturesample.data.ImageItem
import com.example.kjh.architecturesample.util.ImageAsync

class ImageViewHolder(val context: Context, parent: ViewGroup?, val listenerFunc: ((Int) -> Unit)?)
    : RecyclerView.ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_image, parent, false)) {

    private val ivImage by lazy {
        itemView.findViewById(R.id.iv_image) as ImageView
    }

    private val tvTitle by lazy {
        itemView.findViewById(R.id.tv_title) as TextView
    }

    fun onBind(item: ImageItem, position: Int) {
        ImageAsync(context, ivImage).execute(item.resource)

        tvTitle.text = item.title

        itemView.setOnClickListener {
            listenerFunc?.invoke(position)
        }
    }

}