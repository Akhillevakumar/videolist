package com.ateamindia.myapplication

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ateamindia.myapplication.model.VideoListResponse
import com.ateamindia.myapplication.network.getData
import kotlinx.coroutines.launch


class VideoViewModel : ViewModel() {
    val responseData = MutableLiveData<VideoListResponse>()
    fun getVideoListData(userId: String, stringClass: String) {
        viewModelScope.launch {
            try {
                val auth =
                    getData(userId, stringClass)
                responseData.postValue(auth)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}