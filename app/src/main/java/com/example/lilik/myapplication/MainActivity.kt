package com.example.lilik.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import listItem.*
import event.*

class MainActivity : AppCompatActivity() {

    private var items : List<Event> = emptyList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addItem("3","сентябрь","19:00","Lilik lalka", "Parasha palaz", "500-1000","item1")
        addItem("3","сентябрь","19:00","Lilik lalka", "Parasha palaze", "500-1000","item2")
        addItem("3","сентябрь","19:00","Lilik lalka", "Parasha palaz", "500-1000","item3")
        addItem("3","сентябрь","19:00","Lilik lalka", "Parasha palaz", "500-1000","item4")

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        recyclerView.adapter = MyAdapter(items, savedInstanceState)
    }



    private fun addItem(tDay:String,tMonth:String,tTime:String,tName:String,tPlace:String,tPrice: String,tFile: String){
        val listArgs = arrayOf(tDay,tMonth,tTime,tName,tPlace,tPrice)
        val iA = ItemArgs(listArgs,resources.getIdentifier(tFile,"drawable", packageName))
        val ev = Event(iA)
        items+=ev
    }


}
