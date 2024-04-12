package com.example.auth.model

import androidx.annotation.Keep

@Keep
data class AuthModel    (
    val email:String?,
    val password:String?,
)
