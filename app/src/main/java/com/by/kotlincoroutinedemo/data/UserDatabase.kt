package com.by.kotlincoroutinedemo.data

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.by.kotlincoroutinedemo.base.BaseApplication
import com.by.kotlincoroutinedemo.entity.UserEntity

/**
 *
 * @author Catherine Liu
 * 2022/2/21 17:02
 * extend room data base
 *
 **/
//export schema导出架构
@Database(entities = [UserEntity::class], version = 1, exportSchema = false)
abstract class UserDatabase : RoomDatabase() {
    companion object{
        var database: UserDatabase =
            Room.databaseBuilder(BaseApplication.instance(),UserDatabase::class.java,"db_user")
               //是否允许在主线程进行查询
                .allowMainThreadQueries()
                    //数据库创建和打开后的回调，可以重写其中的方法
                .addCallback(object :Callback(){
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)
                        println("on create db_user")
                    }
                })
                    //数据库升级异常之后的回滚
                .fallbackToDestructiveMigration()
                .build()
    }

    abstract fun getUserDao():UserDao
}