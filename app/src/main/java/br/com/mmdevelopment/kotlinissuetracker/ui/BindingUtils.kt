package br.com.mmdevelopment.kotlinissuetracker.ui

import androidx.databinding.BindingAdapter
import br.com.mmdevelopment.kotlinissuetracker.data.model.Issue
import com.google.android.material.textview.MaterialTextView

@BindingAdapter("issueStatus")
fun MaterialTextView.setIssueStatus(item: Issue) {
    text = item.state
}

@BindingAdapter("issueTitle")
fun MaterialTextView.setIssueTitle(item: Issue) {
    text = item.title
}