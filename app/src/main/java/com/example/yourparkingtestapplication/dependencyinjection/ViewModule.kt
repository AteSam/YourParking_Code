package com.example.yourparkingtestapplication.dependencyinjection

import com.example.yourparkingtestapplication.activity.YourParkingTestActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ViewModule {

    @ContributesAndroidInjector
    abstract fun bindYourParkingTestActivity(): YourParkingTestActivity
}