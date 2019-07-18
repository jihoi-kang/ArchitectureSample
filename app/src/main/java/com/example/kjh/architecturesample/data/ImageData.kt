package com.example.kjh.architecturesample.data

import android.content.Context

object ImageData {

    fun getSampleList(context: Context, size: Int) : ArrayList<ImageItem> {
        val list = ArrayList<ImageItem>()
        for(index in 0..size) {
            // 랜덤으로 이미지를 불러온다
            val name = String.format("sample_%02d", (Math.random() * 15).toInt())
            // getIdentifier을 통해 resource 찾아 가져오기
            val resource = context.resources.getIdentifier(name, "drawable", context.packageName)
            list.add(ImageItem(resource, name))
        }
        return list
    }

}