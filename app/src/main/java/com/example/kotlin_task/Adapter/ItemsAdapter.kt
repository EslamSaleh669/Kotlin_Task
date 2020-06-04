package com.example.kotlin_task.Adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_task.R
import com.example.kotlin_task.Room.Enitity.Item
import kotlinx.android.synthetic.main.item_list.view.*


class ItemsAdapter(val items: List<Item>, val callbackInterface: CallbackInterface) :
    RecyclerView.Adapter<ItemsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemsAdapter.ViewHolder {
        val v: View = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ItemsAdapter.ViewHolder, position: Int) {
        holder.itemName.text = items[position].itemName

        if (items[position].itemStatus) {
            holder.itemCard.isEnabled = true
            holder.imgLock.visibility = View.GONE
        } else {
            holder.itemCard.isEnabled = false
            holder.imgLock.visibility = View.VISIBLE
        }

        holder.itemName.setOnClickListener(
            View.OnClickListener {
                callbackInterface.moveNextPage(items[position].itemName)

            }
        )
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
        val itemName = itemView.item
        val itemCard = itemView.cardItem
        val imgLock = itemView.lock
    }

    interface CallbackInterface {
        fun moveNextPage(index: String)
    }

}