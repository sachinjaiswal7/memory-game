package com.example.horizontalrc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.horizontalrc.models.BoardSize
import com.example.horizontalrc.utils.DEFAULT_ICONS

class MainActivity : AppCompatActivity() {

    private lateinit var rc :RecyclerView
    private lateinit var moves:TextView
    private lateinit var pairs:TextView
    private var boardSize :BoardSize= BoardSize.HARD
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val icons = DEFAULT_ICONS.shuffled().take(boardSize.getNumPairs())
        val randomIcons = (icons+icons).shuffled()
        rc = findViewById(R.id.recyclerView)
        moves = findViewById(R.id.moves_text)
        pairs = findViewById(R.id.pairs_text)
        rc.adapter = MyAdapter(this,boardSize,randomIcons)
        rc.setHasFixedSize(true)
        rc.layoutManager = GridLayoutManager(this,boardSize.getWidth())



    }
}