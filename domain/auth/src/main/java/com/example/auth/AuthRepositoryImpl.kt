package com.example.auth

import com.example.auth.model.AuthModel
import com.example.auth.model.AuthToken
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import tandapp.domain.event.Event
import tandapp.utils.SharedPreferencesHelper

class AuthRepositoryImpl(private val dataSource: AuthService) : AuthRepository {
    override suspend fun signIn(dto: AuthModel): Flow<Event<Unit>> = flow {
        val response = dataSource.login(dto)
        if (response.isSuccessful) {
            emit(Event.success(response.body()))
            return@flow
        }
    }

    override suspend fun confirmAccount(token: String): Flow<Event<AuthToken>> = flow {
        val response = dataSource.signUpConfirmation(token)
        if (response.isSuccessful && response.body() != null) {
            val data = response.body()
            SharedPreferencesHelper.saveAccessToken(data?.token.orEmpty())
            emit(Event.success(response.body()))
            return@flow
        }
    }
}