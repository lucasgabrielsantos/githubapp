package com.lucas.github.presentation.ui.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.lucas.github.domain.model.GitHub

class GitHubAdapter(
    private val click: (GitHub) -> Unit
) : ListAdapter<GitHub, GitHubViewHolder>(GitHubAdapter) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GitHubViewHolder {
        return GitHubViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: GitHubViewHolder, position: Int) {
        holder.bind(getItem(position), click)
    }

    private companion object : DiffUtil.ItemCallback<GitHub>() {

        override fun areItemsTheSame(oldItem: GitHub, newItem: GitHub): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: GitHub, newItem: GitHub): Boolean {
            return oldItem == newItem
        }
    }
}