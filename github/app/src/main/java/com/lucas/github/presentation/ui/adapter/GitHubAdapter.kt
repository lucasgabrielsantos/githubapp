package com.lucas.github.presentation.ui.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.lucas.github.domain.model.GitHub
import com.lucas.github.domain.model.ItemsEntity

class GitHubAdapter() : ListAdapter<ItemsEntity, GitHubViewHolder>(GitHubAdapter) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GitHubViewHolder {
        return GitHubViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: GitHubViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    private companion object : DiffUtil.ItemCallback<ItemsEntity>() {

        override fun areItemsTheSame(oldItem: ItemsEntity, newItem: ItemsEntity): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: ItemsEntity, newItem: ItemsEntity): Boolean {
            return oldItem == newItem
        }
    }
}