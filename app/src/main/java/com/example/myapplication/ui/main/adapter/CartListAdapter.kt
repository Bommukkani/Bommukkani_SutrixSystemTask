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

//            var service = ""
//            var img = ""
//            var price = ""
//
//            val value = ArrayList<String>()
//            value.clear()
//            for (item in cartData.service!!) {
//
//                service = "" + service + cartData.service!!.map { it ->
//                    it.name.toString().replace("[", "").replace("]", "")
//                }
//
//                price = "" + price + cartData.service!!.map { it ->
//                    it.price.toString().replace("[", "").replace("]", "")
//
//
//                }
//            }
//
//
//            for (item in cartData.employee!!) {
//                img = "" + cartData.employee!!.map { it ->
//                    it.image.toString().replace("[", "").replace("]", "")
//                }
//                value.add(img)
//
//            }
//
//
//
//
//            Log.v("imggg:", img)
//            itemView.tvName.text = service.toString()
//            itemView.tvPrice.text = "" + price.toString()

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



//            Glide.with(itemView.ivIcon.context)
//                    .load(img)
//                    .into(itemView.ivIcon)
////
//            itemView.setOnClickListener() {
//                Toast.makeText(itemView.context, "Its a toast!", Toast.LENGTH_SHORT).show()
//                val intent = Intent(itemView.context, AddCartActivity::class.java)
//                intent.putExtra("Username", user.image)
//// To pass any data to next activity
//// start your next activity
//                itemView.context.startActivity(intent)
//            }


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

    fun addData(list: List<Cart_DATA>) {
        users.addAll(list)
        notifyDataSetChanged()
    }
}


