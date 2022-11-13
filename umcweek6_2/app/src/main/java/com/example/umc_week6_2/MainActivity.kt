package com.example.umc_week6_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.umc_week6_2.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private val viewBinding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)


        // AppCompatActivitiy()는 Fragment를 상속받기에, MainActivity 클래스는 Fragment 클래스를 내장하고 있다.
        val mainVPAdapter = MainVPAdapter(this)
        viewBinding.vpMain.adapter = mainVPAdapter

        // Tab의 Title을 배열로 지정해둠.
        val tabTitleArray = arrayOf(
            "One",
            "Two",
        )


        // TabLayout 객체를 연결하기 쉽게 TabLayoutMediator 클래스가 구현됨.
        // 이를 이용해서 TabLayout 객체를 연동함.
        /*
            ViewPager에 따라서 TabLayout도 함께 움직이도록 구현가능해짐.
         */

        // tab, position 값은 현재 MainActivity에서 보여지고 있는 위치를 의미한다. - VPAdapter 에서 Postion에 따라서 보여지는 Fragment를 설정해줬다.
        TabLayoutMediator(viewBinding.tabMain, viewBinding.vpMain) {tab, position ->
            tab.text = tabTitleArray[position]

        }.attach()

    }
}