package com.by.kotlincoroutinedemo.entity

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

/**
 *
 * @author Catherine Liu
 * 2022/2/21 17:13
 * user entity
 *
 **/
@Parcelize
@Entity(tableName = "User")
class UserEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Long,
    var name: String
) : Parcelable{
    override fun toString(): String {
        return "id  is $id,and the name is:$name"
    }
}