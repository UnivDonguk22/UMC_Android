package com.example.umc_week6

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.umc_week6.databinding.FragmentPictureBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import java.util.Objects

class PictureFragment: Fragment() {


    // ViewPager2와 TabLayout 객체를 담을 필드변수 선언
    private lateinit var viewPager: ViewPager2
    private lateinit var tabLayout: TabLayout

    private val viewBinding: FragmentPictureBinding by lazy{
        FragmentPictureBinding.inflate(layoutInflater)
    }

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Fragment to Fragment | Fragment에서 다른 Fragment로 전환
//        val rootView = inflater.inflate(R.layout.fragment_picture, container, false)
//
//        val mActivity = activity as MainActivity
//
//        // ViewPager2를 구현하기위해 VPAdapter를 커스텀 마이징함.
//        val pagerAdapter = MainVPAdapter(this)
//


        // Main fragment 지정
//        val view: View = inflater.inflate(R.layout.fragment_picture, container, false)
//        viewPager = view.findViewById(R.id.vp_main)
//        tabLayout = view.findViewById(R.id.tab_main)
        return view

    }

//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        super.onActivityCreated(savedInstanceState)
//
//
//        val pagerAdapter = MainVPAdapter(this)
//        viewPager.adapter = pagerAdapter
//        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
//            override fun onPageSelected(position: Int) {
//                super.onPageSelected(position)
//            }
//        })
//
//        val tabTitleArray = arrayOf(
//            "One",
//            "Two",
//            "Three"
//        )
//
//        TabLayoutMediator(tabLayout, viewPager){ tab, position ->
//            tab.text = tabTitleArray[position]
//        }
//
//    }

}