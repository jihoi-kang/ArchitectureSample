package com.example.kjh.architecturesample.data.source.image

import android.content.Context
import com.example.kjh.architecturesample.data.ImageItem

object SampleImageLocalDataSource : SampleImageSource {

    override fun getImages(context: Context, size: Int, loadImageCallback: SampleImageSource.LoadImageCallback?) {
        val list = ArrayList<ImageItem>()
        for(index in 0..size) {
            // 랜덤으로 이미지를 불러온다
            val name = String.format("sample_%02d", (Math.random() * 15).toInt())
            // getIdentifier을 통해 resource 찾아 가져오기
            val resource = context.resources.getIdentifier(name, "drawable", context.packageName)
            list.add(ImageItem(resource, name))
        }
        loadImageCallback?.onLoadImages(list)
    }
}