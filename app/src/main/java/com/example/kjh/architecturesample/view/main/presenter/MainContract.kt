package com.example.kjh.architecturesample.view.main.presenter

import android.content.Context
import com.example.kjh.architecturesample.adapter.contract.ImageAdapterContract
import com.example.kjh.architecturesample.data.source.image.SampleImageRepository

interface MainContract {

    interface View {

        fun showToast(title: String)

    }

    interface Presenter {

        var view: MainContract.View
        var imageData: SampleImageRepository

        var adapterModel: ImageAdapterContract.Model
        var adapterView: ImageAdapterContract.View?

        fun loadItems(context: Context, isClean: Boolean)

    }

}