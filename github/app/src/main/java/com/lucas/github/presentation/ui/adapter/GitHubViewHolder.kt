package com.lucas.github.presentation.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lucas.github.R
import com.lucas.github.domain.model.GitHub

class GitHubViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(data: GitHub, click: (GitHub) -> Unit) {
        with(itemView) {

        }
    }

    companion object {

        fun from(parent: ViewGroup): GitHubViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val view = layoutInflater.inflate(R.layout.item_github_repository, parent, false)

            return GitHubViewHolder(view)
        }
    }
}