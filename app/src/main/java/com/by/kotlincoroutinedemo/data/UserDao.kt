package com.by.kotlincoroutinedemo.data

import androidx.room.*
import com.by.kotlincoroutinedemo.entity.UserEntity

/**
 *
 * @author Catherine Liu
 * 2022/2/21 17:20
 * User dao
 *
 **/
@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun putUser(cacheBean :UserEntity)

    @Query("select * from User where id =:id")
    suspend fun getUser(id:Long):UserEntity?

    @Query("select * from User")
    suspend fun getAllUser():List<UserEntity>?

    @Delete
    fun delete(userEntity:UserEntity)

    @Update
    fun update(userEntity: UserEntity)

}