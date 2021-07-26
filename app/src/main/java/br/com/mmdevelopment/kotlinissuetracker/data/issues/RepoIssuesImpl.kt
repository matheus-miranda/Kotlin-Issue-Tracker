package br.com.mmdevelopment.kotlinissuetracker.data.issues

import br.com.mmdevelopment.kotlinissuetracker.data.services.GitHubService
import kotlinx.coroutines.flow.flow

class RepoIssuesImpl(private val service: GitHubService) : RepoIssues {

    override suspend fun listIssues(owner: String, repo: String) = flow {
        val listIssues = service.listIssues(owner, repo)
        emit(listIssues)
    }
}