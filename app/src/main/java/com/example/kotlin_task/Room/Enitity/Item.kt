package com.example.kotlin_task.Room.Enitity


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "itemsTable")
data class Item(
    @PrimaryKey
    var itemID: Long?,

    @ColumnInfo(name = "itemName")
    var itemName: String,

    @ColumnInfo(name = "itemStatus")
    var itemStatus: Boolean
)