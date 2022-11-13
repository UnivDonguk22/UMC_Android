package com.example.umc_week6

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class MainVPAdapter(fragmentActivity: PictureFragment): FragmentStateAdapter(fragmentActivity) {

    // ViewPager로 표시할 아이템 갯수
    override fun getItemCount(): Int {
        return 3;
    }

    // 포지션에 따라서 어떤 Fragment를 보여줄 건지 설정
    /*
        createFragment() 메소드에서 position 값을 받아올 때는
        MainActivity의 화면을 토대로 position 값이 받아진다.
     */
    override fun createFragment(position: Int): Fragment {

        // when() 문으로 postion 값에 따라서 보여지는 Fragment를 설정함.
        return when (position) {
            0 -> PictureFragment()
            1 -> OneFragment()
            2 -> TwoFragment()
            else -> PictureFragment()
        }
    }

}