package com.gram15inch.moviesearch.com.gram15inch.moviesearch.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.gram15inch.moviesearch.databinding.LayoutHolderRecentSearchBinding

class RecentSearchAdapter(private val onItemClicked: (String) -> Unit) :
    ListAdapter<String, RecyclerView.ViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return RecentSearchViewHolder(
            LayoutHolderRecentSearchBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = currentList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val current = getItem(position)
        (holder as RecentSearchViewHolder).bind(current)

    }

    inner class RecentSearchViewHolder(var binding: LayoutHolderRecentSearchBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("CheckResult")
        fun bind(res: String) {
            binding.apply {
                holderRecentSearchText.text = res

                holderRecentSearchText.setOnClickListener {
                    onItemClicked(res)
                }
            }
        }

    }

    companion object {
        private val DiffCallback = object : DiffUtil.ItemCallback<String>() {
            override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
                return oldItem == newItem

            }
        }
    }
}