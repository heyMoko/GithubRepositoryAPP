package com.project.githubrepositoryapp.utility

import com.project.githubrepositoryapp.data.entity.GithubRepoEntity
import com.project.githubrepositoryapp.data.response.GithubRepoSearchResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface GithubApiService {

    @GET("search/repositories")
    suspend fun searchRepositories(@Query("q") query: String): Response<GithubRepoSearchResponse>

    @GET("repos/{owner}/{name}")
    suspend fun getRepository(
        @Path("owner") ownerLogin: String,
        @Path("name") repoName: String
    ): Response<GithubRepoEntity>

}
