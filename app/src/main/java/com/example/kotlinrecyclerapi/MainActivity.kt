package com.example.kotlinrecyclerapi

import Model.Data
import Model.reqres
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.OrientationHelper
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.ParsedRequestListener
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val dataList: MutableList<Data> = mutableListOf()
    private lateinit var myAdapter: MyAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //set adapter
        myAdapter = MyAdapter(dataList)

        //Recyclerview

        recyclerview1.layoutManager = LinearLayoutManager(this)
        recyclerview1.addItemDecoration(DividerItemDecoration(this, OrientationHelper.VERTICAL))
        recyclerview1.adapter = myAdapter

        //Networking

        AndroidNetworking.initialize(this)
        AndroidNetworking.get("https://reqres.in/api/users?page=2")
            .build()
            .getAsObject(
                reqres::class.java,
                object : ParsedRequestListener<reqres> {
                    override fun onResponse(response: reqres) {
                        dataList.addAll(response.data)
                        myAdapter.notifyDataSetChanged()
                    }

                    override fun onError(anError: ANError?) {

                    }

                }
            )
    }
}
