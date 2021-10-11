package com.example.yourparkingtestapplication.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.yourparkingtestapplication.R
import com.example.yourparkingtestapplication.databinding.ActivityYourParkingTestBinding
import com.example.yourparkingtestapplication.databinding.ActivityYourParkingTestBindingImpl
import com.example.yourparkingtestapplication.viewmodel.YourParkingTestViewModel
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_your_parking_test.*
import javax.inject.Inject

class YourParkingTestActivity: AppCompatActivity() {

    @Inject
    lateinit var viewModel: YourParkingTestViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityYourParkingTestBinding>(this, R.layout.activity_your_parking_test)
        setSupportActionBar(activity_your_parking_test_toolbar)
        lifecycle.addObserver(viewModel)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
    }
}