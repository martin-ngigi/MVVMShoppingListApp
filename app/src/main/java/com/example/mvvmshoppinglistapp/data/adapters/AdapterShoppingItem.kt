package com.example.mvvmshoppinglistapp.data.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmshoppinglistapp.R
import com.example.mvvmshoppinglistapp.data.db.enties.ShoppingItem
import com.example.mvvmshoppinglistapp.ui.shoppinglist.ShoppingViewModel
import kotlinx.android.synthetic.main.row_shoppint_item.view.*

class AdapterShoppingItem (
    var items: List<ShoppingItem>,
    private val viewModel: ShoppingViewModel
        ): RecyclerView.Adapter<AdapterShoppingItem.ShoppingViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_shoppint_item, parent, false)
        return ShoppingViewHolder(view)
    }

    override fun onBindViewHolder(holder: ShoppingViewHolder, position: Int) {
        val currentShoppingItem = items[position]

        //set data
        holder.itemView.tv_name.text = currentShoppingItem.name
        holder.itemView.tv_amount.text = "${currentShoppingItem.amount}"

        //handle on click listener
        holder.itemView.iv_add.setOnClickListener{
            viewModel.delete(currentShoppingItem)
        }

        //handle on click listener
        holder.itemView.iv_add.setOnClickListener{
            currentShoppingItem.amount ++ //increase by 1
            viewModel.upsert(currentShoppingItem)
        }

        //handle on click listener
        holder.itemView.iv_delete.setOnClickListener{
            currentShoppingItem.amount -- //decrease by 1
            viewModel.upsert(currentShoppingItem)
        }

    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
    inner class ShoppingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)


}