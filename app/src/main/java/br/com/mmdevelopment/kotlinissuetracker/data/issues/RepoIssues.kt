package br.com.mmdevelopment.kotlinissuetracker.data.issues

import br.com.mmdevelopment.kotlinissuetracker.data.model.Issue

interface RepoIssues {
    suspend fun listIssues(owner: String, repo: String): List<Issue>
}