package dev.aftermoon.umc_week2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import dev.aftermoon.umc_week2.databinding.FragmentFirstBinding
import dev.aftermoon.umc_week2.databinding.FragmentSecondBinding

// Fragment 클래스를 상속받아 Fragement로써 활용가능한 클래스로 만듦.
class SecondFragment:Fragment(){

    private lateinit var viewBinding:FragmentSecondBinding


    // Fragment는 onCreateView()를 통해 Layout XML 파일과 연결.
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = FragmentSecondBinding.inflate(layoutInflater)
        // Fragment는 Activity와 달리 onCreateView의 return 값으로 Layout XML을 사용.
        return viewBinding.root

    }

}