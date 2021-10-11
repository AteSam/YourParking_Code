package com.example.yourparkingtestapplication

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class CommonViewHolder(private val dataBinding: ViewDataBinding) : ViewHolder(dataBinding.root) {

    fun <VM> bind(viewModel: VM) {
        dataBinding.setVariable(BR.viewModel, viewModel)
        dataBinding.executePendingBindings()
    }
}