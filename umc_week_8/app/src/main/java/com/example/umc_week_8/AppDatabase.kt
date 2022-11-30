package com.example.umc_week_8

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

// RoomDB 클래스 객체 - RoomDatabase 클래스 상속받음
@Database(entities = [User::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun UserDao(): UserDao

    companion object {

        // RoomDB 객체 선언
        private var appDatabase: AppDatabase? = null

        // Room DB 생성
        @Synchronized
        fun getInstance(context: Context): AppDatabase? {
            // App DataBase 초기화
            if(appDatabase == null){
                synchronized(AppDatabase::class.java) {
                    appDatabase = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java,
                        "app-database"
                    ).allowMainThreadQueries().build()
                }
            }
            return appDatabase
        }
    }

}