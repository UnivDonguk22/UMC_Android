package com.example.umc_week5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.umc_week5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    // 메인 액티비티 XML 객체 선언
    private lateinit var viewBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        // 메인 액티비티 XML 객체 생성
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        // RecyclerView에 표시될 Item을 ArrayList {Data} 객체 타입으로 배열로 선언
        /*
            arrayList는 배열의 크기가 자동으로 배정된다.
            - 동적 배열
         */
        val dataList: ArrayList<Data> = arrayListOf()




        // arrayList 에 데이터 삽입
        dataList.apply{
            // arrayList 타입이 Data 객체이다. | 데이터 삽입 시 Data 객체 타입으로 넣어줌.
            add(Data("hello", "1"))
            add(Data("hello", "2"))
            add(Data("hello", "3"))
            add(Data("hello", "4"))
            add(Data("hello", "5"))
            add(Data("hello", "6"))
            add(Data("hello", "7"))
            add(Data("hello", "8"))
            add(Data("hello", "9"))
            add(Data("hello", "10"))
            add(Data("hello", "11"))
            add(Data("hello", "12"))
            add(Data("hello", "13"))
            add(Data("hello", "14"))
            add(Data("hello", "15"))
            add(Data("hello", "16"))
        }



        val dataRVAdapter = DataRVAdapter(dataList)


        // Recycle View의 Adapter 구현
        viewBinding.rvData.adapter = dataRVAdapter

        // Recycle View의 Item 배치설정
        viewBinding.rvData.layoutManager = LinearLayoutManager(this)
    }
}