package com.example.umc_week_8_roomdb

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {

    /*
        RoomDB 에서 User 객체 삽입 쿼리문
     */
    @Insert
    fun insert(user: User)

    /*
        RoomDB 에서 지정한 User 객체 삭제 쿼리문
     */
    @Delete
    fun delete(user: User)


    /*
        RoomDB 에서 User 객체 모두 조회
     */
    @Query("SELECT * FROM User")
    fun selectAll(): List<User>


    /*
        RoomDB 에서 특정 유저 Id값으로 User 객체 조회
     */
    @Query("SELECT * FROM User WHERE userId = :userId")
    fun selectByUserId(userId: Int): User


    /*
        RoomDB 에서 특정 유저 name으로 User 객체 조회
     */
    @Query("SELECT * FROM User WHERE name = :name")
    fun selectByUserName(name: String): List<User>

    /*
        RoomDB 에서 특정 유저 Id값으로 User 객체의 name 업데이트
     */
    @Query("UPDATE User SET name = :name WHERE userId = :userId")
    fun updateNameByUserId(userId: Int, name: String)

}