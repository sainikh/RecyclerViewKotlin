package com.example.first_project_kotlin


import android.app.Activity
import android.content.Context
import android.service.voice.VoiceInteractionSession
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import android.widget.Button
import android.widget.TextView
import android.widget.Toast

import androidx.recyclerview.widget.RecyclerView

class MyAdapter(private val appontlist: ArrayList<Appoint>, val context: Myinterface):RecyclerView.Adapter<MyAdapter.MyViewHolder>() {



    class MyViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
        val usename: TextView = itemView.findViewById(R.id.textViewName)
        val dell :Button = itemView.findViewById<Button?>(R.id.out)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.cardveiw,parent,false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentpos = appontlist[position]
        holder.usename.text = currentpos.name
        holder.dell.setOnClickListener {
//            Toast.makeText(this,"Item clicked $position",Toast.LENGTH_SHORT).show()
            context.checkPassing(position)

        }


    }



    override fun getItemCount(): Int {
        return appontlist.size
    }
}