package com.github.repo.retrofit

import com.github.repo.model.Example
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import retrofit2.Response
import javax.inject.Inject

class GithubHelperImpl @Inject constructor(
    private val apiService: GitHubService
):GithubHelper{
    override suspend fun getEmployees(repo:String, org: String): Response<List<Example>> = apiService.listRepos(org, repo)
}