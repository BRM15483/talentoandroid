package com.banregio.talentodroid.api

import android.app.Notification
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface JbTalentoApi {
    @GET("test")
    suspend fun getMovies(): Response<List<Notification>>

    companion object {
        operator fun invoke(): JbTalentoApi {
            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://api.simplifiedcoding.in/course-apis/recyclerview/")
                .build()
                .create(JbTalentoApi::class.java)
        }
    }
}