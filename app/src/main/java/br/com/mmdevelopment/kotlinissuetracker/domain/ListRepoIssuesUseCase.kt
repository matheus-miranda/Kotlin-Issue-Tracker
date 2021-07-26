package br.com.mmdevelopment.kotlinissuetracker.domain

import br.com.mmdevelopment.kotlinissuetracker.core.UseCase
import br.com.mmdevelopment.kotlinissuetracker.data.issues.RepoIssues
import br.com.mmdevelopment.kotlinissuetracker.data.model.Issue
import kotlinx.coroutines.flow.Flow

class ListRepoIssuesUseCase(private val repository: RepoIssues) :
    UseCase<String, String, List<Issue>>() {

    override suspend fun execute(param: String, param2: String): Flow<List<Issue>> {
        return repository.listIssues(param, param2)
    }

}