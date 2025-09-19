package com.example.Loginscreen.Core.Network

import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Url

interface ApiServices {
    @GET
    suspend fun <T> get(@Url endpoint: String): T


    @POST
    suspend fun post()
}