package com.ranzan.toastimpl.model

import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("users")
    suspend fun getData(@Query("page") pg: Int): ResponseDTO

}