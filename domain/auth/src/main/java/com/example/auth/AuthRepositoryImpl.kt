package com.example.auth

import com.example.auth.model.AuthModel
import com.example.auth.model.AuthToken
import com.example.auth.model.ConfirmModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext
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

    override suspend fun confirmAccount(dto: ConfirmModel): Flow<Event<AuthToken>> =
        flow {
            val response = dataSource.signUpConfirmation(dto)
            if (response.isSuccessful && response.body() != null) {
                val data = response.body()
                SharedPreferencesHelper.saveAccessToken(data?.token.orEmpty())
                emit(Event.success(response.body()))
                return@flow
            }
            val error = withContext(Dispatchers.IO) { response.errorBody()?.string() }
            emit(Event.error(error))
        }
}