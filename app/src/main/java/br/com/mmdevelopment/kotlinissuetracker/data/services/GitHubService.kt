package br.com.mmdevelopment.kotlinissuetracker.data.services

import br.com.mmdevelopment.kotlinissuetracker.data.model.Issue
import retrofit2.http.GET
import retrofit2.http.Path

interface GitHubService {
    @GET("repos/{owner}/{repo}/issues")
    suspend fun listIssues(@Path("owner") owner: String, @Path("repo") repo: String): List<Issue>
}