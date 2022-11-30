package com.example.umc_week9

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    // 이메일 중복체크를 수행하는 API 호출
    @GET("app/users/email-check")
    fun getCheckEmail(
        @Query("email") email: String
    ): Call<Response>
}