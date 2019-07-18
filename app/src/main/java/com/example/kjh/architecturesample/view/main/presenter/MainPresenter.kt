package com.example.kjh.architecturesample.view.main.presenter

import android.content.Context
import com.example.kjh.architecturesample.adapter.contract.ImageAdapterContract
import com.example.kjh.architecturesample.data.ImageData

class MainPresenter : MainContract.Presenter {

    override lateinit var view: MainContract.View
    override lateinit var imageData: ImageData

    override lateinit var adapterModel: ImageAdapterContract.Model
    override lateinit var adapterView: ImageAdapterContract.View

    override fun loadItems(context: Context, isClean: Boolean) {
        imageData.getSampleList(context, 10).let {
            if(isClean)
                adapterModel.clearItem()

            adapterModel.addItems(it)
            adapterView.notifyAdapter()

        }

    }
}
