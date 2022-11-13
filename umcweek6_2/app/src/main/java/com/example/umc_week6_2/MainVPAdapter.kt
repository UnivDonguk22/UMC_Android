package com.example.umc_week6_2

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

// ViewPager 기능을 사용할 요소들을 Adapter 클래스 생성자로 지정 - Fragment를 ViewPager로 전환
class MainVPAdapter(fragmentActivity: FragmentActivity): FragmentStateAdapter(fragmentActivity) {

    // ViewPager로 표시할 아이템 갯수
    override fun getItemCount(): Int {
        return 2;
    }

    // 포지션에 따라서 어떤 Fragment를 보여줄 건지 설정
    /*
        createFragment() 메소드에서 position 값을 받아올 때는
        MainActivity의 화면을 토대로 position 값이 받아진다.
     */
    override fun createFragment(position: Int): Fragment {

        // when() 문으로 postion 값에 따라서 보여지는 Fragment를 설정함.
        return when (position) {
            0 -> OneFragment()
            1 -> TwoFragment()
            else -> OneFragment()
        }
    }

}