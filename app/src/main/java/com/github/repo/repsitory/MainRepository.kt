package com.github.repo.repsitory

import com.github.repo.retrofit.GithubHelper
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val githubHelper: GithubHelper
){
    suspend fun getEmployee(repo: String, org: String) = githubHelper.getgithubrepos(repo, org)
}