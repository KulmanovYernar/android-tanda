package com.example.auth

import com.example.auth.model.AuthModel
import com.example.auth.model.AuthToken
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface AuthService {
    @POST("auth/login")
    suspend fun login(@Body model: AuthModel): Response<Unit>

    @GET("auth/confirm-account")
    suspend fun signUpConfirmation(@Query("token") token:String): Response<AuthToken>

}