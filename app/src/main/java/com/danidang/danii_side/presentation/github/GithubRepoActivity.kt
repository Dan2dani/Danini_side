package com.danidang.danii_side.presentation.github

import android.os.Bundle
import androidx.activity.viewModels
import com.danidang.danii_side.R
import com.danidang.danii_side.databinding.ActivityGithubRepoBinding
import com.danidang.danii_side.util.binding.BindingActivity

class GithubRepoActivity :
    BindingActivity<ActivityGithubRepoBinding>(R.layout.activity_github_repo) {
    private val viewModel by viewModels<GithubViewModel>()
    private val adapter = RepoAdapter()
    private val mockRepoList = listOf(
        Repo(
            "Android Study",
            "dani43"
        ),
        Repo(
            "Exitt",
            "dani43"
        ),
        Repo(
            "Keep Go Eat",
            "dani43"
        ),
        Repo(
            "BOJ",
            "dani43"
        ),
        Repo(
            "IN SOPT",
            "dani43"
        ),
        Repo(
            "IN SOPT",
            "dani43"
        ),
        Repo(
            "IN SOPT",
            "dani43"
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initData()
        initLayout()
        addObservers()
    }

    private fun initLayout() {
        binding.rvRepos.adapter = adapter
    }

    private fun initData() {
        viewModel.fetchRepositoryList(mockRepoList)
    }

    private fun addObservers() {
        viewModel.repositoryInfo.observe(this) {
            it.let { adapter.submitList(it) }
        }
    }
}