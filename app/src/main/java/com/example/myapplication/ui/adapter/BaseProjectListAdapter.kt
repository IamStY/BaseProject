package com.example.myapplication.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.viewmodels.MainViewModel

class BaseProjectListAdapter  : ListAdapter<MainViewModel.CompaniesVO, BaseProjectListAdapter.BaseProjectItemViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseProjectItemViewHolder {
        val item = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_list_item, parent, false)
        return BaseProjectItemViewHolder(item as ViewGroup)
    }

    override fun onBindViewHolder(holder: BaseProjectItemViewHolder, position: Int) {
        val item = getItem(position)
        holder.itemText.text = item.companiesName
    }


    class BaseProjectItemViewHolder(view: ViewGroup) : RecyclerView.ViewHolder(view) {
        val itemText: TextView = view.findViewById(R.id.itemText)
    }

    private object DiffCallback : DiffUtil.ItemCallback<MainViewModel.CompaniesVO>() {

        override fun areItemsTheSame(oldItem: MainViewModel.CompaniesVO, newItem: MainViewModel.CompaniesVO): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: MainViewModel.CompaniesVO, newItem: MainViewModel.CompaniesVO): Boolean {
            return oldItem == newItem
        }
    }

}