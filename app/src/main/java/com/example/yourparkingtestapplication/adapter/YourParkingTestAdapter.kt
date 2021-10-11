package com.example.yourparkingtestapplication.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.yourparkingtestapplication.CommonViewHolder
import com.example.yourparkingtestapplication.R
import com.example.yourparkingtestapplication.databinding.ItemYourParkingTestRecyclerBinding
import com.example.yourparkingtestapplication.viewmodel.YourParkingTestRecyclerViewModel
import javax.inject.Inject

class YourParkingTestAdapter @Inject constructor(): RecyclerView.Adapter<CommonViewHolder>() {
    private val viewModels = mutableListOf<YourParkingTestRecyclerViewModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommonViewHolder {
        return CommonViewHolder(ItemYourParkingTestRecyclerBinding.bind(LayoutInflater.from(parent.context).inflate(R.layout.item_your_parking_test_recycler, parent, false)))
    }

    override fun getItemCount() = viewModels.size


    override fun onBindViewHolder(holder: CommonViewHolder, position: Int) {
        holder.bind(viewModels[position])
    }

    fun setData(viewModels: List<YourParkingTestRecyclerViewModel>) {
        this.viewModels.clear()
        this.viewModels.addAll(viewModels)
        notifyDataSetChanged()
    }
}