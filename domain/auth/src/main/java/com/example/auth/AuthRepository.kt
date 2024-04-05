package com.example.auth

import com.example.auth.model.AuthToken
import kotlinx.coroutines.flow.Flow
import tandapp.domain.event.Event

interface AuthRepository {
    suspend fun signUp(email:String, password:String) : Flow<Event<AuthToken>>
    suspend fun signUpConfirmation(confirmationToken:String): Flow<Event<AuthToken>>
    suspend fun signIn(email:String, password:String): Flow<Event<AuthToken>>
}