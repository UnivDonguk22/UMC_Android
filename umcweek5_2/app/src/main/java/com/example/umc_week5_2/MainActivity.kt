package com.example.umc_week5_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.umc_week5_2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // main XML 객체 필드변수로 선언
    private lateinit var viewBinding: ActivityMainBinding

    // 메모화면으로 넘겨오는 데이터를 받기위한 필드변수 생성
    private lateinit var getMemoText: ActivityResultLauncher<Intent>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // main XML 객체 생성
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        // Recycler View의 Item 배열 선언 - 초기에 아무값이 없을 땐 배열원소 수 0
        val memoList: ArrayList<MemoData> = arrayListOf()

        // RecyclerView Adapter 객체 생성
        // Adapter 객체 ActivityMain View와 연결 & RecyclerView 배치조정
        val memoRVAdapter = MemoRVAdapter(memoList)
        viewBinding.rvMemolist.adapter = memoRVAdapter
        viewBinding.rvMemolist.layoutManager = LinearLayoutManager(this)

        // 메모 화면으로부터 메모데이터 받기
        getMemoText = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {

                // 메모 화면으로부터 받아온 데이터 처리방식 지정
                val title: String = result.data?.getStringExtra("title").toString()
                val desc: String = result.data?.getStringExtra("desc").toString()
                memoList.apply {
                    add(MemoData(title, desc))
                }
                // RecyclerView Adapter 재구성 - 값이 업데이트 되었으니 Adapter 재구성
                memoRVAdapter.notifyDataSetChanged()
            }
        }

        viewBinding.btnMemo.setOnClickListener {
            // 메모 화면으로 화면 전환 - CallBack 설정을 해둔 채 launch() 메소드로 화면전환
            val intent = Intent(this, MemoActivity::class.java)
            getMemoText.launch(intent)
        }





    }
}