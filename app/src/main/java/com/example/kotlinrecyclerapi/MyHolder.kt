package com.example.kotlinrecyclerapi

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView


class MyHolder(container: ViewGroup) : RecyclerView.ViewHolder(
    //xml deki verilere bakarak arayüz view'i oluşturuyor
    LayoutInflater.from(container.context).inflate(R.layout.item_view, container, false)
)
