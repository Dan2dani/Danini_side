package com.danidang.danii_side.presentation.github

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.danidang.danii_side.databinding.ItemRepoBinding

class RepoAdapter(context: Context) : RecyclerView.Adapter<RepoAdapter.RepoViewHolder>() {
    private val inflater by lazy { LayoutInflater.from(context) }
    private var repoList: List<Repo> = emptyList()

    class RepoViewHolder(
        private val binding: ItemRepoBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: Repo) {
            binding.ivRepo.setImageDrawable(binding.root.context.getDrawable(data.image))
            binding.tvRepoTitle.text = data.title
            binding.tvRepoAuthor.text = data.author
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoViewHolder {
        val binding = ItemRepoBinding.inflate(inflater, parent, false)
        return RepoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RepoViewHolder, position: Int) {
        holder.onBind(repoList[position])
    }

    override fun getItemCount() = repoList.size

    fun setRepoList(repoList: List<Repo>){
        this.repoList = repoList.toList()
        notifyDataSetChanged()
    }
}