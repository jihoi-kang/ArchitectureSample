package com.example.kjh.architecturesample.view.main.presenter

import android.content.Context
import com.example.kjh.architecturesample.adapter.contract.ImageAdapterContract
import com.example.kjh.architecturesample.data.ImageData

class MainPresenter : MainContract.Presenter {

    override lateinit var view: MainContract.View
    override lateinit var imageData: ImageData

    override lateinit var adapterModel: ImageAdapterContract.Model
    override var adapterView: ImageAdapterContract.View? = null
        set(value) {
            field = value
            field?.onClickFunc = { onClickListener(it) }
        }

    override fun loadItems(context: Context, isClean: Boolean) {
        imageData.getSampleList(context, 10).let {
            if(isClean)
                adapterModel.clearItem()

            adapterModel.addItems(it)
            adapterView?.notifyAdapter()

        }

    }

    private fun onClickListener(position: Int) {
        adapterModel.getItem(position).let {
            view.showToast(it.title)
        }
    }

}
