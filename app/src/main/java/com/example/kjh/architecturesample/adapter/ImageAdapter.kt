package com.example.kjh.architecturesample.adapter

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.AsyncTask
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.kjh.architecturesample.R
import com.example.kjh.architecturesample.data.ImageItem
import java.lang.ref.WeakReference

class ImageAdapter(val context: Context) : RecyclerView.Adapter<ImageViewHolder>() {

    var imageList: ArrayList<ImageItem>? = null

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val item = imageList?.get(position)

        ImageAsync(holder?.ivImage).execute(item?.resource)
        holder?.tvTitle?.text = item?.title

        holder?.itemView?.setOnClickListener {
            Toast.makeText(context, "Show ${item?.title}", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            = ImageViewHolder(LayoutInflater.from(context).inflate(R.layout.item_image, parent, false))

    override fun getItemCount() = imageList?.size ?: 0

    inner class ImageAsync(imageView: ImageView?) : AsyncTask<Int, Void, Bitmap>() {

        val imageViewReference: WeakReference<ImageView?> = WeakReference(imageView)

        override fun doInBackground(vararg params: Int?): Bitmap {
            val options = BitmapFactory.Options()
            options.inSampleSize = 2
            return BitmapFactory.decodeResource(context.resources, params[0] as Int, options)
        }

        override fun onPreExecute() {
            super.onPreExecute()
            imageViewReference.get()?.setImageResource(0)
        }

        override fun onPostExecute(result: Bitmap?) {
            super.onPostExecute(result)
            result?.let {
                imageViewReference.get()?.setImageBitmap(result)
            }
        }
    }
}