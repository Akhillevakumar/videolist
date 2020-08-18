package com.ateamindia.myapplication.model

import com.google.gson.annotations.SerializedName

data class VideoListResponse(

	@field:SerializedName("success")
	val success: Boolean? = null,

	@field:SerializedName("video_thumbnail_path")
	val videoThumbnailPath: String? = null,

	@field:SerializedName("video_lists")
	val videoLists: ArrayList<VideoListsItem?>? = null
)

data class VideoListsItem(

	@field:SerializedName("video_thumbnail_name")
	val videoThumbnailName: String? = null,

	@field:SerializedName("video_title")
	val videoTitle: String? = null,

	@field:SerializedName("short_desc")
	val shortDesc: String? = null,

	@field:SerializedName("is_featured")
	val isFeatured: Int? = null,

	@field:SerializedName("video_id")
	val videoId: Int? = null,

	@field:SerializedName("long_desc")
	val longDesc: String? = null
)
