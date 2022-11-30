package com.example.umc_week_8_roomdb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.umc_week_8_roomdb.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        // RoomDB 객체 생성
        val roomDb = AppDatabase.getInstance(this)

        if (roomDb != null){

            // RoomDB에 삽입할 User 데이터 객체 생성 (User 데이터 객체 새롭게 생성)
            val user = User("김동욱", 20)
            val user2 = User("이동욱", 22)

            // RoomDB에 User 객체 삽입
            roomDb.UserDao().insert(user)
            roomDb.UserDao().insert(user2)

            // RoomDB에서 특정 User Id를 가진 User 조회
            // RoomDB에서 모든 User 객체 조회
            val getUser = roomDb.UserDao().selectByUserId(2)
            val userList = roomDb.UserDao().selectAll()
            Log.d("DB", "Get User : ${getUser}")
            Log.d("DB", "User List : ${userList}")
        }


    }
}