package com.example.kjh.architecturesample.data.source.image

import android.content.Context
import com.example.kjh.architecturesample.data.ImageItem

interface SampleImageSource {

    interface LoadImageCallback {

        fun onLoadImages(list: ArrayList<ImageItem>)

    }

    fun getImages(context: Context, size: Int, loadImageCallback: LoadImageCallback?)

}