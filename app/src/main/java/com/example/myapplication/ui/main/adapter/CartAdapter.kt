package com.example.myapplication.ui.main.adapter

import android.app.Activity
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.R
import com.example.myapplication.data.model.Datum
import com.example.myapplication.utils.Shared_Common_Pref
import kotlinx.android.synthetic.main.cart_item_layout.view.*


class CartAdapter(
        private val users: ArrayList<Datum>,
        var activity: Activity,
        var current_list: ArrayList<Datum> = ArrayList<Datum>(),
        var sharedCommonPref: Shared_Common_Pref,
        val service_data: String


) : RecyclerView.Adapter<CartAdapter.DataViewHolder>() {

    lateinit var itemSelectedListner : ItemSelectedListner

    inner class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(user: Datum, activity: Activity, current_list: ArrayList<Datum>, sharedCommonPref: Shared_Common_Pref, service_data: String) {


            itemView.textViewUserName.text = user.name
            Glide.with(itemView.ivIcon.context)
                    .load(user.image)
                    .into(itemView.ivIcon)

            itemView.llcartParent.setBackgroundColor(if (user.isSelected()) activity.resources.getColor(R.color.greentrans) else Color.WHITE)
            itemView.llcartParent.setOnClickListener() {

                // values.add("" + user.id + "," + user.image + "," + user.name + "," + user.price)

//                current_list.add(user)
//
//                val distinct = current_list.toSet().toList();
//
//
//                val gson = Gson()
//
//                sharedCommonPref.save("CART_DATA", gson.toJson(distinct))
//                Log.v("service_data:", service_data)
//
//                Log.v("cart_list:", gson.toJson(current_list))

                user.setSelected(!user.isSelected())
                //AddCartActivity.addData()
//                itemView.llcartParent.setBackgroundColor(itemView.context.resources.getColor(R.color.greentrans))
                itemView.llcartParent.setBackgroundColor(if (user.isSelected()) activity.resources.getColor(R.color.greentrans) else Color.WHITE)
//                Toast.makeText(itemView.context, user.name, Toast.LENGTH_SHORT).show()
                itemSelectedListner.onItemSelected(user, user.isSelected())
            }


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            DataViewHolder(
                    LayoutInflater.from(parent.context).inflate(
                            R.layout.cart_item_layout, parent,
                            false
                    )
            )

    override fun getItemCount(): Int = users.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) =
            holder.bind(users[position], activity, current_list, sharedCommonPref,service_data)

    fun addData(list: List<Datum>) {
        users.addAll(list)
        notifyDataSetChanged()
    }



    private fun saveData() {


        sharedCommonPref.save("", "")
//        val sharedPreferences = activity.getSharedPreferences("shared preferences", MODE_PRIVATE)
//        val editor = sharedPreferences.edit()
//        val gson = Gson()
//        val json = gson.toJson(values)
//        editor.putString("task list", json)
//        editor.apply()
    }

//    private fun loadData() {
//        val sharedPreferences = activity.getSharedPreferences("shared preferences", MODE_PRIVATE)
//        val gson = Gson()
//        val json = sharedPreferences.getString("task list", "")
//        val type = object : TypeToken<ArrayList<String>>() {
//        }.type
//
//        if (json == null)
//            values = ArrayList()
//        else
//            values = gson.fromJson(json, type)
//    }

    @JvmName("setItemSelectedListner1")
    fun setItemSelectedListner(itemSelectedListner: ItemSelectedListner){
        this.itemSelectedListner = itemSelectedListner
    }

    interface ItemSelectedListner{
        fun onItemSelected(user: Datum, isSlected : Boolean)
    }

}

