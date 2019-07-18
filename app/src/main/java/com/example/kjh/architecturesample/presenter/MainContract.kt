package com.example.kjh.architecturesample.presenter

import android.content.Context
import com.example.kjh.architecturesample.data.ImageData
import com.example.kjh.architecturesample.data.ImageItem

interface MainContract {

    interface View {

        fun updateItems(items: ArrayList<ImageItem>, isClean: Boolean)
        fun notifyAdapter()

    }

    interface Presenter {

        var view: View
        var imageData: ImageData

        fun loadItems(context: Context, isClean: Boolean)

    }

}