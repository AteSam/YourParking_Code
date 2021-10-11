package com.example.yourparkingtestapplication.module

import com.example.yourparkingtestapplication.service.RedditService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


@Module
class RedditModule {

    @Provides
    fun provideRedditService(): RedditService {
        val client: OkHttpClient =
            OkHttpClient.Builder().build()


        return Retrofit.Builder()
            .baseUrl("https://reddit.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(client)
            .build()
            .create(RedditService::class.java)
    }
}