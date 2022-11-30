package com.example.umc_week9

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.umc_week9.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        // 서버 통신을 하기 위한 Retrofit 객체 생성
        // 서버 주소로 접속
        val retrofit = Retrofit.Builder()
            .baseUrl("https://prodmp.eric-rc.shop")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        // 서버의 API 통신 객체 생성
        val apiService = retrofit.create(ApiService::class.java)


        // 서버 통신 객체에서 이메일 중복 확인 API 요청 & 비동기적으로 처리하기 위해 enqueue 사용
        apiService.getCheckEmail("test@test.com").enqueue(object: Callback<Response> {
            // API 응답 성공 메소드
            override fun onResponse(call: Call<Response>, response: retrofit2.Response<Response>) {
                if(response.isSuccessful){
                    val responseData = response.body()

                    if(responseData != null){
                        Log.e("Retrofit", "Response\nCode: ${responseData.code} Message: ${responseData.message}")
                    }
                }
                else {
                    // HTTP에서 제공해주는 요청 시 발생하는 이슈를 알려주는 코드이다.
                    Log.w("Retrofit", "Response Not Successful ${response.code()}")
                }

                }

            // API 응답 실패 메소드
            override fun onFailure(call: Call<Response>, t: Throwable) {
                Log.e("Retrofit", "Error!", t)
            }

        })
    }
}