package br.com.mmdevelopment.kotlinissuetracker.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.mmdevelopment.kotlinissuetracker.data.model.Issue
import br.com.mmdevelopment.kotlinissuetracker.domain.ListRepoIssuesUseCase
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class IssuesViewModel(private val listRepoIssuesUseCase: ListRepoIssuesUseCase) : ViewModel() {

    private val _issues = MutableLiveData<State>()
    val issues: LiveData<State> = _issues

    fun getIssues(owner: String, repo: String) {
        viewModelScope.launch {
            listRepoIssuesUseCase(owner, repo)
                .onStart {
                    _issues.postValue(State.Loading)
                }
                .catch {
                    _issues.postValue(State.Error(it))
                }
                .collect {
                    _issues.postValue(State.Success(it))
                }
        }
    }

    sealed class State {
        object Loading : State()
        data class Success(val list: List<Issue>) : State()
        data class Error(val error: Throwable) : State()
    }
}