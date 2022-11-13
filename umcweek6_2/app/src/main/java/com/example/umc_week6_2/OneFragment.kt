package com.example.umc_week6_2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.umc_week6_2.databinding.FragmentOneBinding

class OneFragment: Fragment() {


    private val viewBinding: FragmentOneBinding by lazy{
        FragmentOneBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return viewBinding.root
    }

}