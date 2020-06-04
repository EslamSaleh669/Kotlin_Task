package com.example.kotlin_task.Room.Dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.kotlin_task.Room.Enitity.Item

@Dao
interface ItemDao {
    @Query("SELECT * FROM itemsTable")
    fun allItems(): LiveData<List<Item>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertItem(item: Item)
}