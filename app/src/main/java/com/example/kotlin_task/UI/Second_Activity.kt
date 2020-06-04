package com.example.kotlin_task.UI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_task.Adapter.ItemsCheckedAdapter
import com.example.kotlin_task.R
import com.example.kotlin_task.Room.Enitity.Item
import com.example.kotlin_task.Room.ItemsViewModel
import kotlinx.android.synthetic.main.activity_second_.*
import org.jetbrains.anko.doAsync

class Second_Activity : AppCompatActivity(), ItemsCheckedAdapter.CallbackInterfaceSecondPage {

    private var recycleItem: RecyclerView? = null
    private var btnConfirm: Button? = null
    private lateinit var model: ItemsViewModel

    private var totalCheck: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_)
        initView()
        onClick()
        showItems() }

    fun initView() {
        recycleItem = this.recycleCheckedItems
        btnConfirm = this.confirm
    }


    fun onClick() {
        btnConfirm!!.setOnClickListener(View.OnClickListener {
            Log.e("** total show",totalCheck.toString());
            if (totalCheck == 0) {
                Toast.makeText(
                    applicationContext,
                    resources.getString(R.string.validateConfirm),
                    Toast.LENGTH_LONG
                ).show();
            } else {
                updateItem2()
                val intent = Intent(this, First_Activity::class.java)
                startActivity(intent)
            }
        })
    }

    fun showItems() {
        model = ViewModelProviders.of(this).get(ItemsViewModel::class.java)

        val linearLayoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        recycleItem!!.layoutManager = linearLayoutManager

        // Observe the model
        model.allItems.observe(this, Observer { items ->
            // Data bind the recycler view
            recycleItem!!.adapter = ItemsCheckedAdapter(items, this)
        })
    }

    fun updateItem2() {
        model = ViewModelProviders.of(this).get(ItemsViewModel::class.java)
        doAsync {
            model.update(Item(2, "item 2", true))
        }
    }

    override fun moveToCheck(pos: Int, checked: Boolean) {
        Log.e("** data", pos.toString() + " : " + checked);
        if (checked) {
            totalCheck += 1;
        } else {
            totalCheck -= 1;
        }
        Log.e("** total", totalCheck.toString());

    }

}
