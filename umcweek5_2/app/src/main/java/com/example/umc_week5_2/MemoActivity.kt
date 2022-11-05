package com.example.umc_week5_2

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.umc_week5_2.databinding.ActivityMemoBinding

class MemoActivity: AppCompatActivity(){

    // Memo XML 객체 선언
    private lateinit var viewBinding: ActivityMemoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        // Memo XML 객체 생성
        viewBinding = ActivityMemoBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        // 메모 저장 버튼이 클릭되었을 때 메모 저장하고, 메인화면으로 전환
        viewBinding.btnCheck.setOnClickListener {
            val title = viewBinding.editTitle.text.toString()
            val desc = viewBinding.editMemo.text.toString()

            // 메인화면으로 EditText 값 가지고 화면전환
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("title",title)
            intent.putExtra("desc",desc)

            setResult(RESULT_OK, intent)
            if(!isFinishing) finish()
        }

    }
}