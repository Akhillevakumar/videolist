package com.ateamindia.myapplication.network

import com.ateamindia.myapplication.model.VideoListResponse
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.FormBody
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import okhttp3.Request

suspend fun getData(userId: String, classString: String): VideoListResponse =
    withContext(Dispatchers.IO) cr@{

        val url = HttpUrl.Builder()
            .scheme("http")
            .host("adaladmin.ap-south-1.elasticbeanstalk.com")
            .encodedPath("/api/v1/mobile/adal_video_listing")
            .build()
        val body = FormBody.Builder()
            .add("user_id", userId)
            .add("class", classString)
            .build()

        val request = Request.Builder()
            .url(url)
            .post(body)
            .acceptJson()
            .build()
        val response = OkHttpClient.Builder().build().newCall(request).execute()
        when (response.code) {
            200 -> {
                val gson = Gson()
                val s = response.body!!.string()
                val topic = gson.fromJson(s, VideoListResponse::class.java)
                return@cr topic
            }

            else -> throw AmbiguousResponseException()
        }
    }


fun Request.Builder.acceptJson() = addHeader(
    "Accept",
    "application/json"
)