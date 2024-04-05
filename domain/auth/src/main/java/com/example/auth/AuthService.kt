package com.example.auth

import com.example.auth.model.AuthToken
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface AuthService {
    @POST("signup")
    suspend fun signUp(@Query("email") email:String, @Query("password") password:String): Response<AuthToken>

    @GET("confirm-account")
    suspend fun signUpConfirmation(@Query("confirmationToken") confirmationToken:String): Response<AuthToken>

    @POST("signin")
    suspend fun signIn(@Query("email") email:String, @Query("password") password:String): Response<AuthToken>

}