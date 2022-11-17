package com.example.first_project_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(),Myinterface{
    private var recyclerView  : RecyclerView? = null
    val usersList = arrayListOf<Appoint>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        val userText = findViewById<EditText>(R.id.editTextTextPersonName)

        val btn = findViewById<Button>(R.id.button)
        recyclerView = findViewById<RecyclerView>(R.id.myrecycle)
        recyclerView?.adapter = MyAdapter(usersList,this)

        btn.setOnClickListener{
            val mytest = userText.text.toString()
            recyclerView?.layoutManager = LinearLayoutManager(this)

//            Toast.makeText(this,mytest,Toast.LENGTH_LONG).show()

            val users = Appoint(mytest)
            usersList.add(users)



        }


    }

    override fun checkPassing(possition: Int) {

//       Toast.makeText(this,"check paressed $possition",Toast.LENGTH_SHORT).show()
        usersList.removeAt(possition)
        recyclerView?.adapter?.notifyItemRemoved(possition)
        recyclerView?.adapter?.notifyItemRangeChanged(possition, recyclerView?.adapter?.itemCount!!)


    }


}