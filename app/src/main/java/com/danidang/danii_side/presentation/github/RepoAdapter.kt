package com.danidang.danii_side.presentation.github

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.danidang.danii_side.databinding.ItemRepoBinding
import com.danidang.danii_side.databinding.LayoutGithubHeaderBinding

class RepoAdapter : ListAdapter<Repo, RecyclerView.ViewHolder>(GithubDiffCallback) {
    private lateinit var inflater: LayoutInflater

    class RepoViewHolder(
        private val binding: ItemRepoBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: Repo) {
            binding.repo = data
        }
    }

    class HeaderViewHolder(
        private val binding: LayoutGithubHeaderBinding
    ) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (!::inflater.isInitialized)
            inflater = LayoutInflater.from(parent.context)

        return when (viewType) {
            HEADER_TYPE -> {
                val binding = LayoutGithubHeaderBinding.inflate(inflater, parent, false)
                HeaderViewHolder(binding)
            }
            else -> {
                val binding = ItemRepoBinding.inflate(inflater, parent, false)
                RepoViewHolder(binding)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is RepoViewHolder -> holder.onBind(currentList[position - 1])
        }
    }

    override fun getItemCount() = currentList.size + 1

    override fun getItemViewType(position: Int): Int {
        return when (position) {
            0 -> HEADER_TYPE
            else -> REPO_TYPE
        }
    }

    companion object {
        const val HEADER_TYPE = 1
        const val REPO_TYPE = 2
    }

    object GithubDiffCallback : DiffUtil.ItemCallback<Repo>() {
        override fun areItemsTheSame(oldItem: Repo, newItem: Repo): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Repo, newItem: Repo): Boolean {
            return oldItem == newItem
        }
    }
}