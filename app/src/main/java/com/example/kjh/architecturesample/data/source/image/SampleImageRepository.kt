package com.example.kjh.architecturesample.data.source.image

import android.content.Context
import com.example.kjh.architecturesample.data.ImageItem

object SampleImageRepository : SampleImageSource {

    private val sampleImageLocalDataSource = SampleImageLocalDataSource

    override fun getImages(context: Context, size: Int, loadImageCallback: SampleImageSource.LoadImageCallback?) {
        sampleImageLocalDataSource.getImages(context, size, object : SampleImageSource.LoadImageCallback {
            override fun onLoadImages(list: ArrayList<ImageItem>) {
                loadImageCallback?.onLoadImages(list)
            }
        })
    }
}