package com.danidang.danii_side.presentation.github

import android.os.Bundle
import com.danidang.danii_side.R
import com.danidang.danii_side.databinding.ActivityGithubRepoBinding
import com.danidang.danii_side.util.binding.BindingActivity

class GithubRepoActivity : BindingActivity<ActivityGithubRepoBinding>(R.layout.activity_github_repo) {
    private val mockRepoList = listOf<Repo>(
        Repo(
            R.drawable.img_heart,
            "Android Study",
            "dani43"
        ),
        Repo(
            R.drawable.img_heart,
            "Exitt",
            "dani43"
        ),
        Repo(
            R.drawable.img_heart,
            "Keep Go Eat",
            "dani43"
        ),
        Repo(
            R.drawable.img_heart,
            "BOJ",
            "dani43"
        ),
        Repo(
            R.drawable.img_heart,
            "IN SOPT",
            "dani43"
        ),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val adapter = RepoAdapter(this)
        binding.rvRepos.adapter = adapter
        adapter.setRepoList(mockRepoList)

    }
}