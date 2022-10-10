package dev.aftermoon.umc_week2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dev.aftermoon.umc_week2.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivitySecondBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivitySecondBinding.inflate(layoutInflater)

        setContentView(viewBinding.root)

        /*
            이전 Activity에서 넘겨준 데이터를 받기.
            intent 객체에 보관된 데이터를 받는다.
         */
        val extras = intent.extras
        val data = extras!!["text"] as String

        viewBinding.tvText.text=data



    }
}