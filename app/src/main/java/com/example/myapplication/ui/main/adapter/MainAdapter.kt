package com.example.myapplication.ui.main.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.R
import com.example.myapplication.data.model.Datum
import com.example.myapplication.utils.Shared_Common_Pref
import com.google.gson.Gson
import kotlinx.android.synthetic.main.item_layout.view.*
import kotlin.collections.ArrayList


class MainAdapter(
        private val users: ArrayList<Datum>,
        var sharedCommonPref: Shared_Common_Pref


) : RecyclerView.Adapter<MainAdapter.DataViewHolder>() {

    private lateinit var itemClickListner: ItemClickListner
    inner class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(user: Datum, sharedCommonPref: Shared_Common_Pref) {
            itemView.tvName.text = user.name
            itemView.tvPrice.text = "" + user.price.toString()
            Glide.with(itemView.ivIcon.context)
                    .load(user.image)
                    .into(itemView.ivIcon)


            itemView.setOnClickListener() {
               sharedCommonPref.save("service_data", Gson().toJson(user))
                println(user)
                itemClickListner.onItemClicked(user)
            }


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            DataViewHolder(
                    LayoutInflater.from(parent.context).inflate(
                            R.layout.item_layout, parent,
                            false
                    )
            )

    override fun getItemCount(): Int = users.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) =
            holder.bind(users[position], sharedCommonPref)

    fun addData(list: List<Datum>) {


        users.addAll(list)
        notifyDataSetChanged()

    }

    fun setItemClickListner(itemSelectedListner: ItemClickListner){
        this.itemClickListner = itemSelectedListner
    }

    interface ItemClickListner{
        fun onItemClicked(user: Datum)
    }

}

