package com.example.yourparkingtestapplication.viewmodel

import android.view.View
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class YourParkingTestRecyclerViewModel @Inject constructor() : ViewModel() {

    val commentText = ObservableField<String>()
    val authorText = ObservableField<String>()

    fun setData(text: String, authorFullname: String) {
        commentText.set(text)
        authorText.set(authorFullname)
    }

    fun onItemClicked(v: View) {
        // TODO: 09/03/2021 implement onClick
    }
}