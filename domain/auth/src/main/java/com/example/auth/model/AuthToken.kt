package com.example.auth.model

import androidx.annotation.Keep

@Keep
data class AuthToken(
    val token:String? = ""
)
