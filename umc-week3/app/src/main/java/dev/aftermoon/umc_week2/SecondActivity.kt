package dev.aftermoon.umc_week2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dev.aftermoon.umc_week2.databinding.ActivitySecondBinding
import android.content.Intent;

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
        val data = extras!!["inputEditText"] as String

        viewBinding.tvText.text=data


        /*
            Button 클릭 시 MainFragmentActivity로 전환
        */
        viewBinding.btnMainfragment.setOnClickListener {
            val intent = Intent(this, MainFragmentActivity::class.java)
            startActivity(intent)
        }



    }
}