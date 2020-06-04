package com.example.kotlin_task.Room.DateBase


import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import android.content.Context
import com.example.kotlin_task.Room.Dao.ItemDao
import com.example.kotlin_task.Room.Enitity.Item



@Database(entities = arrayOf(Item::class), version = 1, exportSchema = false)
abstract class AppDateBase : RoomDatabase() {
    abstract fun itemDao(): ItemDao

    companion object {
        private var INSTANCE: AppDateBase? = null
        fun getInstance(context: Context): AppDateBase {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context,
                    AppDateBase::class.java,
                    "roomdb"
                ).build()
            }

            return INSTANCE as AppDateBase
        }
    }
}