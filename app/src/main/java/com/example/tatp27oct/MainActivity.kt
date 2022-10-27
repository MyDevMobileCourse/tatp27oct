package com.example.tatp27oct

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    var dataList = listOf(
        Pair("Ariana", R.drawable.ariana),
        Pair("Beja", R.drawable.beja),
        Pair("Ben Arous", R.drawable.benarous),
        Pair("Bizerte", R.drawable.bizerte),
        Pair("Gabès", R.drawable.gabes),
        Pair("Gafsa", R.drawable.gafsa),
        Pair("Jendouba", R.drawable.jendouba),
        Pair("Kairouan", R.drawable.kairouan),
        Pair("Kasserine", R.drawable.kasserine),
        Pair("Kébili", R.drawable.kebili),
        Pair("Kef", R.drawable.kef),
        Pair("Mahdia", R.drawable.mahdia),
        Pair("Manouba", R.drawable.manouba),
        Pair("Médenine", R.drawable.medenine),
        Pair("Monastir", R.drawable.monastir),
        Pair("Nabeul", R.drawable.nabeul),
        Pair("Sfax", R.drawable.sfax),
        Pair("Sidi Bouzid", R.drawable.sidibouzid),
        Pair("Siliana", R.drawable.siliana),
        Pair("Sousse", R.drawable.sousse),
        Pair("Tataouine", R.drawable.tataouine),
        Pair("Tozeur", R.drawable.tozeur),
        Pair("Tunis", R.drawable.tunis),
        Pair("Zaghouan", R.drawable.zaghouan)
    )

    lateinit var recycler : RecyclerView
    private lateinit var adapter: StatesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recycler = findViewById(R.id.recyclerView)
        adapter = StatesAdapter(dataList)
        val layoutRecycler = LinearLayoutManager(applicationContext)
        recycler.layoutManager = layoutRecycler
        recycler.adapter = adapter
    }
}