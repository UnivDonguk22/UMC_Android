package com.example.umc_week9

//API 응답 Data 객체를 지정해줌
data class Response(
    val isSuccess: Boolean,
    val code: Int,
    val message: String
)
