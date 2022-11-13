package com.example.umc_week6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.umc_week6.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    // viewBinding 객체 선언 즉시, 값 생성
    private val viewBinding: ActivityMainBinding by lazy{
        ActivityMainBinding.inflate(layoutInflater)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)

        // MainActivity에 처음 접근했을 때 띄어지는 화면을 설정해줌
        supportFragmentManager
            .beginTransaction()
            .replace(viewBinding.containerFragment.id, HomeFragment())
            .commitAllowingStateLoss()

        // Bottom Navigation View 설정
        /*
            run 메소드는 "범위함수"라고 함
            범위함수는 속성에 속한 요소들을 바로 사용할 수 있다.
         */
        viewBinding.navBottom.run{
            // navBottom 속성이 클릭되었을 때 아래와 같은 동작실행
            setOnItemSelectedListener {

                // when() 문은 Switch 문과 동등하게 사용됨
                // menu의 itemId로 식별한다.
                when (it.itemId) {
                    R.id.menu_home -> {
                        supportFragmentManager
                            .beginTransaction()
                            .replace(viewBinding.containerFragment.id, HomeFragment())
                            .commitAllowingStateLoss()
                    }
                    R.id.menu_setting -> {
                        supportFragmentManager
                            .beginTransaction()
                            .replace(viewBinding.containerFragment.id, SettingFragment())
                            .commitAllowingStateLoss()
                    }
                    R.id.store_picture -> {
                        supportFragmentManager
                            .beginTransaction()
                            .replace(viewBinding.containerFragment.id, PictureFragment())
                            .commitAllowingStateLoss()
                    }
                }
                true
            }

            //BottomNavigation - Store_picture | Fragment to Fragment
                fun changeFragment(index: Int){
                    when(index){
                    1 -> {
                        supportFragmentManager
                            .beginTransaction()
                            .replace(R.id.container_fragment, PictureFragment())
                            .commitAllowingStateLoss()
                    }
                    2 -> {
                        supportFragmentManager
                            .beginTransaction()
                            .replace(R.id.container_fragment, OneFragment())
                            .commitAllowingStateLoss()
                    }
                    3 -> {
                        supportFragmentManager
                            .beginTransaction()
                            .replace(R.id.container_fragment, TwoFragment())
                            .commitAllowingStateLoss()
                    }
                }
            }


            // MainActivity에 접근 시 초기설정 Fragment를 빼당해줌.
            selectedItemId = R.id.menu_home
        }

    }
}