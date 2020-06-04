package com.example.kotlin_task.UI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_task.Adapter.ItemsAdapter
import com.example.kotlin_task.R
import com.example.kotlin_task.Room.Enitity.Item
import com.example.kotlin_task.Room.ItemsViewModel
import kotlinx.android.synthetic.main.activity_first_.*
import org.jetbrains.anko.doAsync

class First_Activity : AppCompatActivity(), ItemsAdapter.CallbackInterface {


    private var recycleItem: RecyclerView? = null
    private lateinit var model: ItemsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_)

        initView()
        showItems()
    }


    fun initView() {
        recycleItem = this.recycleItems
    }

    fun showItems() {
        model = ViewModelProviders.of(this).get(ItemsViewModel::class.java)

        val linearLayoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        recycleItem!!.layoutManager = linearLayoutManager

        addItems()
        model.allItems.observe(this, Observer { items ->
            recycleItem!!.adapter = ItemsAdapter(items, this)
        })
    }

    fun addItems() {
        model.allItems.observe(this, Observer { items ->
            if (items.size == 0) {
                doAsync {
                    model.insert(Item(1, "item 1", true))
                    model.insert(Item(2, "item 2", false))
                    model.insert(Item(3, "item 3", false))
                    model.insert(Item(4, "item 4", false))
                    model.insert(Item(5, "item 5", false))
                }
            }
        })

    }

    override fun moveNextPage(index: String) {
        val intent = Intent(this,Second_Activity::class.java)
        startActivity(intent)
    }

}
