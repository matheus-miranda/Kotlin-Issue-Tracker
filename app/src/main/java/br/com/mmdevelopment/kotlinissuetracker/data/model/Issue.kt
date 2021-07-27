package br.com.mmdevelopment.kotlinissuetracker.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Issue(
    val id: Long,
    val title: String,
    val user: User,
    val state: String,
    val created_at: String,
    val pull_request: PullRequest,
    val body: String
) : Parcelable