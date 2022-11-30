package com.example.umc_week_8

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.umc_week_8.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)


        // sharedPreferences 객체 생성
        val sharedPrefs = getSharedPreferences("sharedprefs", Context.MODE_PRIVATE)
        val editor = sharedPrefs.edit()

        // 객체 초기화 용
        editor.putString("eric", "")
        editor.apply()
        // 객체 초기화 용

        // sharedPreferences 객체에 데이터 저장
        editor.putString("eric", "Android")

        /*
            sharedPreferences 객체 apply() 하지 않고 getString()
            가져오기
         */
        val beforeapplyvalue = sharedPrefs.getString("eric", "")
        Log.d("SP Before", "${beforeapplyvalue}")

        editor.apply()

        /*
            sharedPreferences 객체 apply() 수행하고, getString()
            가져오기
         */
        val spvalue = sharedPrefs.getString("eric", "")
        Log.d("SP", "${spvalue}")



        /*
            결론
            apply() 적용해야지만, 성공적으로 sharedPreferences에 데이터를 저장하고,
             가져올 수 있다.
         */
    }
}
