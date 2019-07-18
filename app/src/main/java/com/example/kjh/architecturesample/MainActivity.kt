package com.example.kjh.architecturesample

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.kjh.architecturesample.adapter.ImageAdapter
import com.example.kjh.architecturesample.data.ImageData
import com.example.kjh.architecturesample.data.ImageItem
import com.example.kjh.architecturesample.presenter.MainContract
import com.example.kjh.architecturesample.presenter.MainPresenter
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity(), MainContract.View {

    private var imageAdapter: ImageAdapter? = null

    private lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        presenter = MainPresenter().apply {
            view = this@MainActivity
            imageData = ImageData
        }

        // Adapter 생성
        imageAdapter = ImageAdapter(this)
        // RecyclerView에 adapter를 셋팅
        rv_image_list.adapter = imageAdapter

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        presenter.loadItems(this, false)
    }

    override fun updateItems(items: ArrayList<ImageItem>, isClean: Boolean) {
        imageAdapter?.apply {
            if(isClean)
                imageList?.clear()

            imageList = items
        }
    }

    override fun notifyAdapter() {
        imageAdapter?.notifyDataSetChanged()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId

        // reload 액션 발생
        if(id == R.id.action_reload) {
            imageAdapter?.apply {
                // 기존 itemList clear
                imageList?.clear()
                // 새로운 itemList 불러와서 저장
                imageList = ImageData.getSampleList(context, 10)
                // UI Change
                notifyDataSetChanged()
            }
            return true
        }

        return super.onOptionsItemSelected(item)
    }

}
