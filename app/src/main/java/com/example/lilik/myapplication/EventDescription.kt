package com.example.lilik.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TabItem
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import event.*


class EventDescription() : AppCompatActivity() {

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event_description)

    }

    private var currentEvent : Event = Event(ItemArgs(emptyArray(),1))

    fun setEvent(ev : Event){
        currentEvent = ev
        setValues()
    }

    private fun setValues(){
        val icon: ImageView = findViewById(R.id.imgAfisha)
        icon.setImageResource(currentEvent.args.ivSrc)

        val txtDay : TextView = findViewById(R.id.txtDay)
        txtDay.text = (currentEvent.args.values[0]+currentEvent.args.values[1])

        val txtTime : TextView = findViewById(R.id.txtTime)
        txtTime.text = currentEvent.args.values[2]

        val txtName : TextView = findViewById(R.id.txtName)
        txtName.text = currentEvent.args.values[3]

        val txtPlace : TextView = findViewById(R.id.txtPlace)
        txtPlace.text = currentEvent.args.values[4]

        val txtPrice : TextView = findViewById(R.id.txtPrice)
        txtPrice.text = currentEvent.args.values[5]

        val txtAddress : TextView = findViewById(R.id.txtAddress)
        txtAddress.text = currentEvent.place

        val txtText : TextView = findViewById(R.id.txtText)
        txtText.text = currentEvent.description

        val tiDescription : TabItem = findViewById(R.id.tiDescription)
        tiDescription.setOnClickListener(View.OnClickListener() {
            fun onClick(v: View) {
                changeInfo(currentEvent.description)
            }})

        val tiPlace : TabItem = findViewById(R.id.tiPlace)
        tiPlace.setOnClickListener(View.OnClickListener() {
            fun onClick(v: View) {
                changeInfo(currentEvent.place)
            }})
    }

    fun changeInfo(text : String){
        val txtText : TextView = findViewById(R.id.txtText)
        txtText.text = text
    }


}
