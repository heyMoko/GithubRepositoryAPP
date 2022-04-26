package com.project.githubrepositoryapp.data.response

import com.project.githubrepositoryapp.data.entity.GithubRepoEntity

data class GithubRepoSearchResponse(
    val totalCount: Int,
    val items: List<GithubRepoEntity>
)
