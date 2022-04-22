package com.github.repo.retrofit

import com.github.repo.model.Example
import retrofit2.Response
import javax.inject.Inject

class GithubHelperImpl @Inject constructor(
    private val githubService: GitHubService
):GithubHelper{
    override suspend fun getgithubrepos(repo:String, org: String): Response<List<Example>> = githubService.listRepos(org, repo)
}