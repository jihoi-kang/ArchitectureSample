package com.example.kjh.architecturesample.adapter.contract

import com.example.kjh.architecturesample.data.ImageItem

interface ImageAdapterContract {

    interface View {

        fun notifyAdapter()

    }

    interface Model {

        fun addItems(imageList: ArrayList<ImageItem>)
        fun clearItem()

    }

}