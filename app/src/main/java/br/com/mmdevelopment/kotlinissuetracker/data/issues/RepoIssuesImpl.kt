package br.com.mmdevelopment.kotlinissuetracker.data.issues

import br.com.mmdevelopment.kotlinissuetracker.core.RemoteException
import br.com.mmdevelopment.kotlinissuetracker.data.services.GitHubService
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException

class RepoIssuesImpl(private val service: GitHubService) : RepoIssues {

    override suspend fun listIssues(owner: String, repo: String) = flow {
        try {
            val listIssues = service.listIssues(owner, repo)
            emit(listIssues)
        } catch (ex: HttpException) {
            throw RemoteException(ex.message ?: "Search unavailable")
        }
    }
}