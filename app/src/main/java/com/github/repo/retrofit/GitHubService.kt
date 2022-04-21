package com.github.repo.retrofit

import android.os.Bundle
import com.github.repo.model.Example
import dagger.Provides
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import javax.inject.Inject

interface GitHubService {
    @GET("/repos/{org}/{repo}/issues")
    suspend fun listRepos(@Path("org") org:String, @Path("repo") repo:String): Response<List<Example>>
}

interface GithubHelper {
    suspend fun getEmployees(repo: String, org: String): Response<List<Example>>
}

interface GetGihubIssueCallback {
    fun callback(org: String, repo: String)
}