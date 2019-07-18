package com.example.kjh.architecturesample.presenter

import android.content.Context
import com.example.kjh.architecturesample.data.ImageData

class MainPresenter : MainContract.Presenter {

    override lateinit var view: MainContract.View
    override lateinit var imageData: ImageData

    override fun loadItems(context: Context, isClean: Boolean) {
        imageData.getSampleList(context, 10).let {
            view.updateItems(it, isClean)
            view.notifyAdapter()
        }

    }
}
