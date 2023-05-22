package com.lucas.github.presentation.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.lucas.github.commons.ViewsExt.loadUrl
import com.lucas.github.databinding.ItemGithubRepositoryBinding
import com.lucas.github.domain.model.ItemsEntity
import com.lucas.github.presentation.ui.adapter.GitHubAdapter.GitHubViewHolder.DiffCallback

class GitHubAdapter : ListAdapter<ItemsEntity, GitHubAdapter.GitHubViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): GitHubViewHolder {
        val binding = ItemGithubRepositoryBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return GitHubViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GitHubViewHolder, position: Int) {
        val currentItem = getItem(position)
        holder.bind(currentItem)
    }

    class GitHubViewHolder(private val binding: ItemGithubRepositoryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: ItemsEntity) {
            binding.apply {
                repositoryName.text = data.fullName
                repositoryDescription.text = data.description
                user.text = data.owner.login
                forks.text = data.forksCount.toString()
                starsCount.text = data.stargazersCount.toString()
                acount.loadUrl(data.owner.avatarUrl)
                //     itemView.setOnClickListener { listener.clickListener(item)}
            }
        }

        class DiffCallback : DiffUtil.ItemCallback<ItemsEntity>() {
            override fun areItemsTheSame(oldItem: ItemsEntity, newItem: ItemsEntity) =
                oldItem == newItem

            override fun areContentsTheSame(oldItem: ItemsEntity, newItem: ItemsEntity) =
                oldItem == newItem
        }
    }
}