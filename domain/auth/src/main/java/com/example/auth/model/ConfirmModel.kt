package com.example.auth.model

import androidx.annotation.Keep

@Keep
data class ConfirmModel(
    val token: String,
    val email: String
)
