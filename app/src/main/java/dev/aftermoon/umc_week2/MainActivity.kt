package dev.aftermoon.umc_week2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dev.aftermoon.umc_week2.databinding.ActivityMainBinding

// Intent를 사용하기 위해 android에서 모듈을 불러와야 한다.
import android.content.Intent;

/*
    MainActivity 파일은 AppCompatActivity를 상속받는다.
    따라서, AppCompatActivity 파일에 존재하는 메소드를 가져와 사용할 수 있고,
    viewBinding을 이용할 때도 layoutInflter 를 가져와 사용하고 있다~~
 */
class MainActivity : AppCompatActivity() {

    // ViewBinding을 이용해
    // Layout XML을 객체로 변환 후 Layout에 대한 객체를 저장할 변수를 필드변수로 선언함.
    private lateinit var viewBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // layout XML을 객체로 변환시켜 || 이전에 선언한 XML 객체를 받는 변수에 저장한다.
        viewBinding = ActivityMainBinding.inflate(layoutInflater)

        // 기존 MainActivity는 R클래스로써 Layout과 매핑한다.
        // viewBinding을 이용해 layout XML을 매핑한다. (객체로써 받아서 활용하고 있다.)
        setContentView(viewBinding.root)

        // ViewBinding을 통해 layout XML에 접근이 가능해짐 (layout -> 객체로 넘어올 때는 카멜 케이스로 네이밍이 자동 설정됨.)
        viewBinding.btnNext.setOnClickListener {

            // Activity의 이동을 위해 Intent 객체를 이용.
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("text", "first_receive_data")
            startActivity(intent)
            /*
                Intent는 메시지 객체로써, 한 Activity에서 다른 Activity로 넘어갈 때
                추가적인 Data 값을 담아서 보낼 수 있다.
                - 한 Activity에서 처리된 Data를 다른 Activity에 넘겨줄 때 유용하다~~
            */

        }
    }
}