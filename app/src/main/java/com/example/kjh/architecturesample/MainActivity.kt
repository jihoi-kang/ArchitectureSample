package com.example.kjh.architecturesample

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.kjh.architecturesample.adapter.ImageAdapter
import com.example.kjh.architecturesample.data.ImageData
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    private var imageAdapter: ImageAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        // Adapter 생성
        imageAdapter = ImageAdapter(this)
        // Adapter에 itemList를 불러와서 저장
        imageAdapter?.imageList = ImageData.getSampleList(this, 10)
        // RecyclerView에 adapter를 셋팅
        rv_image_list.adapter = imageAdapter

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
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
