package br.com.mmdevelopment.kotlinissuetracker.data.services

import retrofit2.http.GET
import retrofit2.http.Path

interface GitHubService {
    @GET("repos/{owner}/{repo}/issues")
    suspend fun listRepos(@Path("owner") owner: String, @Path("repo") repo: String): List<Repo>
}