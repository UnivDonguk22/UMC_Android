package com.example.umc_week6

import com.example.umc_week6.databinding.FragmentTwoBinding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class TwoFragment: Fragment() {

    private val viewBinding: FragmentTwoBinding by lazy{
        FragmentTwoBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return viewBinding.root
    }

}