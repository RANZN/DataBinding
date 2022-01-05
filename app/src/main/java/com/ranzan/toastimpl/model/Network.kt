package com.ranzan.toastimpl.model

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Network {

    companion object {
        private const val BASE_URL = "https://reqres.in/api/"

        private fun getRetrofitInstance(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        val apiService: ApiService = getRetrofitInstance().create(ApiService::class.java)

    }
}