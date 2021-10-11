package com.example.yourparkingtestapplication.service

import com.example.yourparkingtestapplication.models.RedditCommentModel
import io.reactivex.Single
import retrofit2.http.GET

interface RedditService {

    @GET("r/Android/hot.json")
    fun getRedditPosts(): Single<RedditCommentModel>

}