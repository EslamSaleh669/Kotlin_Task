package com.example.kotlin_task.Room

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import android.app.Application
import com.example.kotlin_task.Room.DateBase.AppDateBase
import com.example.kotlin_task.Room.Enitity.Item



class ItemsViewModel(application: Application) : AndroidViewModel(application) {
    private val db: AppDateBase = AppDateBase.getInstance(application)

    internal val allItems: LiveData<List<Item>> = db.itemDao().allItems()

    fun insert(student: Item) {
        db.itemDao().insertItem(student)
    }

    fun update(item: Item) {
        db.itemDao().insertItem(item)
    }
}