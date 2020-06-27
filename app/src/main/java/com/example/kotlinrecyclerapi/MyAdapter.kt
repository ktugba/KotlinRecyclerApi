package com.example.kotlinrecyclerapi

import Model.Data
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_view.view.*

class MyAdapter(private val dataList: MutableList<Data>) : RecyclerView.Adapter<MyHolder>() {

    private lateinit var context: Context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        context = parent.context
        return MyHolder(
            LayoutInflater.from(context).inflate(
                R.layout.item_view,
                parent,
                false
            ) as ViewGroup
        )
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val data = dataList[position]

        val userAvatar: ImageView = holder.itemView.user_avatar
        val userFullNameTextView: TextView = holder.itemView.user_full_name
        val userEmail: TextView = holder.itemView.user_email

        val fullName = "${data.firstName} ${data.lastName}"
        userFullNameTextView.text = fullName
        val emailName = "${data.email}"
        userEmail.text = emailName

        Picasso.with(context)
            .load(data.avatar)
            .into(userAvatar)

        holder.itemView.setOnClickListener {
            Toast.makeText(context, fullName, Toast.LENGTH_SHORT).show()
        }

    }


}