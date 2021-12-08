package com.example.horizontalrc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var rc :RecyclerView
    private lateinit var moves:TextView
    private lateinit var pairs:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rc = findViewById(R.id.recyclerView)
        moves = findViewById(R.id.moves_text)
        pairs = findViewById(R.id.pairs_text)
        rc.adapter = MyAdapter(this,8)
        rc.setHasFixedSize(true)
        rc.layoutManager = GridLayoutManager(this,2)



    }
}