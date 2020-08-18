package com.ateamindia.myapplication.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.ateamindia.myapplication.R
import com.ateamindia.myapplication.model.VideoListResponse
import com.bumptech.glide.Glide

class SuggestionsListAdapter : RecyclerView.Adapter<SuggestionsListAdapter.ViewHolder>() {
    var data: VideoListResponse? = null
    var ctx: Context? = null

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var image: ImageView = view.findViewById(R.id.image)

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SuggestionsListAdapter.ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.single_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return data?.videoLists?.size!!
    }

    override fun onBindViewHolder(holder: SuggestionsListAdapter.ViewHolder, position: Int) {
        Glide.with(ctx!!)
            .load(data?.videoThumbnailPath + data?.videoLists?.get(position)?.videoThumbnailName)
            .into(holder.image)
    }

}