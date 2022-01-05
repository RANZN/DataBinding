package com.ranzan.toastimpl.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ranzan.toastimpl.R
import com.ranzan.toastimpl.databinding.ItemLayoutBinding
import com.ranzan.toastimpl.model.DataItem

class RecyclerViewAdapter(private val list: ArrayList<DataItem>) :
    RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        var itemLayoutBinding: ItemLayoutBinding =
            DataBindingUtil.inflate(
                layoutInflater,
                R.layout.item_layout,
                parent,
                false
            )
        return RecyclerViewViewHolder(itemLayoutBinding)
    }

    override fun onBindViewHolder(holder: RecyclerViewViewHolder, position: Int) {
        holder.bindData(list[position])
    }

    override fun getItemCount(): Int = list.size


    class RecyclerViewViewHolder(private val itemLayoutBinding: ItemLayoutBinding) :
        RecyclerView.ViewHolder(itemLayoutBinding.root) {
        fun bindData(dataItem: DataItem) {
            itemLayoutBinding.data = dataItem
            Glide.with(itemLayoutBinding.image).load(dataItem.avatar).into(itemLayoutBinding.image)
        }
    }
}