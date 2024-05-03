package com.example.auth

import com.example.auth.model.AuthModel
import com.example.auth.model.AuthToken
import kotlinx.coroutines.flow.Flow
import tandapp.domain.event.Event

interface AuthRepository {
    suspend fun signIn(dto: AuthModel) : Flow<Event<Unit>>
    suspend fun confirmAccount(token:String): Flow<Event<AuthToken>>
}