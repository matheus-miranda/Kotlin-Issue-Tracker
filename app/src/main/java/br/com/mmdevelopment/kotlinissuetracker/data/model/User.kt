package br.com.mmdevelopment.kotlinissuetracker.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(
    val avatar_url: String
) : Parcelable