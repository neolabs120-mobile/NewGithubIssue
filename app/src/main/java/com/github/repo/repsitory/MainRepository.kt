package com.github.repo.repsitory

import com.github.repo.retrofit.GithubHelper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val apiHelper: GithubHelper
){
    suspend fun getEmployee(repo: String, org: String) = apiHelper.getEmployees(repo, org)
}