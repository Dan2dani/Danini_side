package com.danidang.danii_side.presentation.github

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GithubViewModel : ViewModel() {
    private val _repositories = MutableLiveData<List<Repo>>()
    val repositoryInfo: LiveData<List<Repo>> get() = _repositories

    fun fetchRepositoryList(repoList: List<Repo>) {
        _repositories.value = repoList
    }
}