package com.example.simplenote.database

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "tb_none")
@Parcelize
 data class Note (
       @PrimaryKey()
       @ColumnInfo(name="id")
       val id: Int = 0,

       @ColumnInfo(name= "title")
       var title: String? =null,

       @ColumnInfo(name= "description")
       var description : String? = null,

       @ColumnInfo(name = "date")
       var date:String? =null,
       ) : Parcelable
