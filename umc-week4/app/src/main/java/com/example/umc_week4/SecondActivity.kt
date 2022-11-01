package com.example.umc_week4

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.umc_week4.databinding.ActivitySecondBinding

class SecondActivity: AppCompatActivity() {

    // viewBinding 클래스 받아오기
    private lateinit var viewBinding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivitySecondBinding.inflate(layoutInflater)
        val view = viewBinding.root
        setContentView(view)

        // intent로 전환된 SecondActivity에서 전달된 데이터를 받아 Second XML text에 보여줌.
        viewBinding.txtSecond.text = intent.getStringExtra("data")


    }
}