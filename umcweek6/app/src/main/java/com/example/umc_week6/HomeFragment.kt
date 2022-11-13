package com.example.umc_week6

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.umc_week6.databinding.FragmentHomeBinding

// Fragment 클래스 상속받아서 Fragment 클래스 파일로 구현
class HomeFragment: Fragment() {


    private val viewBinding: FragmentHomeBinding by lazy{
        FragmentHomeBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return viewBinding.root
    }

}