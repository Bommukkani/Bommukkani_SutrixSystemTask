package com.example.myapplication.ui.main.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.data.model.Cart_DATA
import kotlinx.android.synthetic.main.cart_list_item_layout.view.*
import kotlinx.android.synthetic.main.item_layout.view.*
import kotlinx.android.synthetic.main.item_layout.view.tvName
import kotlinx.android.synthetic.main.item_layout.view.tvPrice


class CartListAdapter(
    private val users: ArrayList<Cart_DATA>


) : RecyclerView.Adapter<CartListAdapter.DataViewHolder>() {

    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(cartData: Cart_DATA) {

            itemView.recyclerview.setAdapter(
                CartFileListAdapter(
                    cartData.employee!!
                )
            )
            itemView.service_recyclerview.setAdapter(
                CartServiceListAdapter(
                    cartData.service!!
                )
            )



        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        DataViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.cart_list_item_layout, parent,
                false
            )
        )

    override fun getItemCount(): Int = users.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) =
        holder.bind(users[position])


}


