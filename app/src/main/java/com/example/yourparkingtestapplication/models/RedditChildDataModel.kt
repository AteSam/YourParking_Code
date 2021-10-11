package com.example.yourparkingtestapplication.models

import com.google.gson.annotations.SerializedName

data class RedditChildDataModel(val selftext: String, @SerializedName("author_fullname")val authorFullname: String)