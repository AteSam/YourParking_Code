package com.example.yourparkingtestapplication.dependencyinjection

import com.example.yourparkingtestapplication.application.YourParkingTestApplication
import com.example.yourparkingtestapplication.module.RedditModule
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ApplicationModule::class,
        AndroidInjectionModule::class,
        ViewModule::class,
        RedditModule::class
    ]
)
interface ApplicationComponent : AndroidInjector<YourParkingTestApplication>