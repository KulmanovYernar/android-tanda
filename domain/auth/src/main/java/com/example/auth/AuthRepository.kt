package com.example.auth

import com.example.auth.model.AuthModel
import com.example.auth.model.AuthToken
import kotlinx.coroutines.flow.Flow
import tandapp.domain.event.Event

interface AuthRepository {
    suspend fun signUp(dto: AuthModel) : Flow<Event<Unit>>
    suspend fun signUpConfirmation(token:String): Flow<Event<AuthToken>>
//    suspend fun signIn(email:String, password:String): Flow<Event<AuthToken>>
}