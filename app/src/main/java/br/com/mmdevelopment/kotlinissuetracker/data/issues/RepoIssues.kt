package br.com.mmdevelopment.kotlinissuetracker.data.issues

import br.com.mmdevelopment.kotlinissuetracker.data.model.Issue
import kotlinx.coroutines.flow.Flow

interface RepoIssues {
    suspend fun listIssues(owner: String, repo: String): Flow<List<Issue>>
}