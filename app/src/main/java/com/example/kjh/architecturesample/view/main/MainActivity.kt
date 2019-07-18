package com.example.kjh.architecturesample.view.main

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.kjh.architecturesample.R
import com.example.kjh.architecturesample.adapter.ImageAdapter
import com.example.kjh.architecturesample.data.ImageData
import com.example.kjh.architecturesample.view.main.presenter.MainContract
import com.example.kjh.architecturesample.view.main.presenter.MainPresenter
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity(), MainContract.View {

    private lateinit var imageAdapter: ImageAdapter

    private lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        // Adapter 생성
        imageAdapter = ImageAdapter(this)
        // RecyclerView에 adapter를 셋팅
        rv_image_list.adapter = imageAdapter

        presenter = MainPresenter().apply {
            view = this@MainActivity
            imageData = ImageData
            adapterView = imageAdapter
            adapterModel = imageAdapter
        }

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        presenter.loadItems(this, false)
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
            presenter.loadItems(this, true)
            return true
        }

        return super.onOptionsItemSelected(item)
    }

    override fun showToast(title: String) {
        Toast.makeText(this, "OnClick Item $title", Toast.LENGTH_SHORT).show()
    }
}
