package com.myone.mainScreen.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.myone.R
import com.myone.databinding.HomeRecyclerviewItemBinding

open class HomeRecyclerViewAdapter(val callbackListener: HomeRecyclerViewListener): RecyclerView.Adapter<HomeRecyclerViewAdapter.ViewHolder>() {

    lateinit var binding: HomeRecyclerviewItemBinding

    var data = arrayListOf<String>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.home_recyclerview_item,parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position], callbackListener)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    open fun setData(items : List<String>) {
        data.clear()
        data.addAll(items)
        notifyDataSetChanged()
    }

    class ViewHolder(val binding: HomeRecyclerviewItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(data:String, callbackListener: HomeRecyclerViewListener) {
            binding.data = data
            initializelisteners(data, callbackListener)
        }

        private fun initializelisteners(data:String, callbackListener: HomeRecyclerViewListener) {
            binding.root.rootView.setOnClickListener {
                callbackListener.onItemClicked(data)
            }
        }
    }
}