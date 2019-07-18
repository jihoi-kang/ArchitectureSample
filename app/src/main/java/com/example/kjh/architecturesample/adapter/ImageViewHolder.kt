package com.example.kjh.architecturesample.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kjh.architecturesample.R

class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val ivImage by lazy {
        itemView.findViewById(R.id.iv_image) as ImageView
    }

    val tvTitle by lazy {
        itemView.findViewById(R.id.tv_title) as TextView
    }

}