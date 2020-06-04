package com.example.kotlin_task.Adapter


import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_task.R
import com.example.kotlin_task.Room.Enitity.Item
import kotlinx.android.synthetic.main.item_checked_list.view.*

class ItemsCheckedAdapter(
    val items: List<Item>,
    val callbackInterface: CallbackInterfaceSecondPage
) :
    RecyclerView.Adapter<ItemsCheckedAdapter.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ItemsCheckedAdapter.ViewHolder {
        val v: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_checked_list, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ItemsCheckedAdapter.ViewHolder, position: Int) {
        holder.check.text = items[position].itemName

        holder.check.setOnCheckedChangeListener { buttonView, isChecked ->
            callbackInterface.moveToCheck(items[position].itemID!!.toInt(), isChecked)
            //Do Whatever you want in isChecked
        }
    }


    override fun getItemCount(): Int {
        return items.size
    }

    override fun getItemId(position: Int): Long {
        return super.getItemId(position)
    }

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val check = itemView.checkbox

    }

    interface CallbackInterfaceSecondPage {
        fun moveToCheck(pos: Int, status: Boolean)
    }

}