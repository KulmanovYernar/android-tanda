package com.example.auth

import com.example.auth.model.AuthModel
import com.example.auth.model.AuthToken
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import tandapp.domain.event.Event

class AuthRepositoryImpl(private val dataSource: AuthService) : AuthRepository {
    override suspend fun signUp(dto: AuthModel): Flow<Event<Unit>>  = flow {
        val response = dataSource.signUp(dto)
        if (response.isSuccessful && response.body() != null) {
            emit(Event.success(response.body()))
            return@flow
        }
    }

    override suspend fun signUpConfirmation(token:String): Flow<Event<AuthToken>>  = flow {
        val response = dataSource.signUpConfirmation(token)
        if (response.isSuccessful && response.body() != null) {
            emit(Event.success(response.body()))
            return@flow
        }
    }

    override suspend fun signIn(email:String, password:String): Flow<Event<AuthToken>>  = flow {
        val response = dataSource.signIn(email, password)
        if (response.isSuccessful && response.body() != null) {
            emit(Event.success(response.body()))
            return@flow
        }
    }
}