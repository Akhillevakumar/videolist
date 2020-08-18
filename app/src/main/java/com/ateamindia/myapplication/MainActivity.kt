package com.ateamindia.myapplication

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.ateamindia.myapplication.model.VideoListResponse
import com.ateamindia.myapplication.ui.SuggestionsListAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val viewModel by viewModels<VideoViewModel>()
    lateinit var suggestionsListAdapter: SuggestionsListAdapter

    private val dataObsever = Observer<VideoListResponse> { response ->
        suggestionsListAdapter = SuggestionsListAdapter().apply {
            ctx = baseContext
            data = response
        }
        suggestion_recycler_view.apply {
            adapter = suggestionsListAdapter
            layoutManager =
                LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL, false)
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel.responseData.observe(this, dataObsever)
        viewModel.getVideoListData("155", "5")
    }

}