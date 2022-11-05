package com.example.umc_week4


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.EditText
import android.widget.Toast
import com.example.umc_week4.databinding.ActivityMainBinding

// Diolog 구현하기 위한 모듈
import android.content.DialogInterface
import androidx.appcompat.app.AlertDialog


class MainActivity : AppCompatActivity() {

    /*
        TO DO 1.
        onStop() 메소드 호출 시 Edit Text 값을 기억할 필드변수 선언
     */
    private lateinit var edit_data: String


    // ActivityMainBinding 클래스에 대한 타입으로 viewBinding 변수 선언
    private lateinit var viewBinding: ActivityMainBinding
    // onCreate() 메소드 구현 | ViewBinding으로 Layout 객체로 생성 & Layout 객체받아서 화면 출력
    override fun onCreate (savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // viewBinding에 ActivityMainBinding 객체 생성해줌.
        viewBinding = ActivityMainBinding.inflate(layoutInflater)

        // view에 viewBinding의 모든 객체를 지정함.
        val view = viewBinding.root

        // MainActivity에서 viewBinding 객체를 모두 보여줌.
        setContentView(view)

        viewBinding.btnMain.setOnClickListener {
            // 버튼이 클릭되면, SecondActivity로 전환
            /*
                명시적 Intent로 Activity 전환
             */
            var intent = Intent(this, SecondActivity::class.java)

            // intent에 전달 데이터 값을 담어서 전달가능
            intent.putExtra("data", viewBinding.edtMain.text.toString())

            // startActivity() 메소드로 intent 실행시켜 Activity 전환
            startActivity(intent)
        }

    }

    override fun onStop() {
        super.onStop()

        // Edit Text 값은 전역변수에 기억
        edit_data = viewBinding.edtMain.text.toString()

        // Edit Text 값 비우기
        /*
            Edit Text의 타입인 Editable 맞추느라 고생했다.
            null도 안되고, 오직 Editable 값만 받아줌.
         */
        viewBinding.edtMain.text = Editable.Factory.getInstance().newEditable("")
    }

    override fun onRestart() {
        super.onRestart()

        // Diolog를 사용해 메모장 이어서 작성할 건지 유무 묻고 나눠서 실행
        // 홈버튼 눌러서 나갔다가, 다시 앱에 접속했을 때 실행됨

            // 다이얼로그를 생성하기 위해 Builder 클래스 생성자를 이용해 줍니다.
            val builder = AlertDialog.Builder(this)
            builder.setTitle("메모장 관리자")
                .setMessage("메모장에 작성 중인 글을 이어서 작성할까요?")
                .setPositiveButton("예",
                    DialogInterface.OnClickListener { dialog, id ->
                        // Editable 형태로 바꿔서 대입 || Edit Text는 Editable 타입 아닌 그외의 것들은 안받아줌.
                        viewBinding.edtMain.text = Editable.Factory.getInstance().newEditable(edit_data)
                    })
                .setNegativeButton("아니요",
                    DialogInterface.OnClickListener { dialog, id ->
                        edit_data = ""
                    })
            // 다이얼로그를 띄워주기22
            builder.show()

    }
}