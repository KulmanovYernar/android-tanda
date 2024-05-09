package com.example.auth

import com.example.auth.model.AuthModel
import com.example.auth.model.AuthToken
import com.example.auth.model.ConfirmModel
import kotlinx.coroutines.flow.Flow
import tandapp.domain.event.Event

interface AuthRepository {
    suspend fun signIn(dto: AuthModel): Flow<Event<Unit>>
    suspend fun confirmAccount(dto: ConfirmModel): Flow<Event<AuthToken>>
}