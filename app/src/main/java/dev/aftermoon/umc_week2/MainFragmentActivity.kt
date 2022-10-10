package dev.aftermoon.umc_week2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dev.aftermoon.umc_week2.databinding.ActivityMainFragmentBinding
import dev.aftermoon.umc_week2.databinding.FragmentSecondBinding

class MainFragmentActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityMainFragmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainFragmentBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)


            /*
                즉, main에 할당한 layout들 중 지정된 layout을 Fragment로 대체한다.
                지정당하지 않은 main의 layout은 그대로 view로 표시된다. - Fragment의 활용

                (Intent를 사용하면 새로운 View를 보일 때 처음부터 끝까지 다시 설정해줘야 하지만!)
                Fragment를 도입하면, 이전 View에서 똑같이 보이는 View를 작성할 필요없이
                view 이동 시 변경되는 부분만 변경해서 View를 보일 수 있다.)
            */

        supportFragmentManager
            // Fragment 변경을 시작하겠다.
            .beginTransaction()
            // Fragment를 교체하는 명령
            // activity_main_fragment에서 지정한 frameLayout을 FirstFragment로 대체함.
            .replace(viewBinding.frameFragment.id, FirstFragment())
            .commitAllowingStateLoss()

        /*
           실습 2.Fragment 1, 2 버튼을 눌렀을 때 번호에 맞는 Activity - Layout으로 View 전환
        */
        viewBinding.btnFragment1.setOnClickListener {
            supportFragmentManager
                // Fragment 변경을 시작하겠다.
                .beginTransaction()
                // Fragment를 교체하는 명령
                // activity_main_fragment에서 지정한 frameLayout을 FirstFragment로 대체함.
                .replace(viewBinding.frameFragment.id, FirstFragment())
                .commitAllowingStateLoss()
        }

        viewBinding.btnFragment2.setOnClickListener {
            supportFragmentManager
                // Fragment 변경을 시작하겠다.
                .beginTransaction()
                // Fragment를 교체하는 명령
                // activity_main_fragment에서 지정한 frameLayout을 FirstFragment로 대체함.
                .replace(viewBinding.frameFragment.id, SecondFragment())
                .commitAllowingStateLoss()
        }
    }
}