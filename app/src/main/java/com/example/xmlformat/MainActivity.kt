package com.example.xmlformat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.io.IOException

class MainActivity : AppCompatActivity() {

    private lateinit var rvMain: RecyclerView
    private var games= listOf<dat.Student>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvMain = findViewById(R.id.rvmain)
        rvMain.layoutManager= LinearLayoutManager(this)
        rvMain.adapter=RVAdapter(games)

        try {
            val parser = xmlparser()
            val iStream = assets.open("data.xml")
            games = parser.parse(iStream)
            rvMain.adapter=RVAdapter(games)

        } catch (e: IOException) {
            println("ISSUE: $e")
        }
    }
}


