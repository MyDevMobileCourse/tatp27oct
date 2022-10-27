package com.example.tatp27oct

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

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
    lateinit var fab: FloatingActionButton
    var selectedItem : Pair<String,Int>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init();
        val layoutRecycler = LinearLayoutManager(applicationContext)
        recycler.layoutManager = layoutRecycler
        recycler.adapter = adapter

    }
    fun init(){
        recycler = findViewById(R.id.recyclerView)
        fab = findViewById(R.id.floatingActionButton)
        adapter = StatesAdapter(dataList)

        fab.isVisible = false
        initListeners()
    }
    fun initListeners(){
        if (adapter!=null){
            adapter.onItemClick = {
                Toast.makeText(applicationContext, it.first+" selected ", Toast.LENGTH_SHORT).show()
                selectedItem = it
                fab.isVisible = true
            }
        }
        fab.setOnClickListener {
            println("fab clicked")
            if(selectedItem != null){
                val builderP =AlertDialog.Builder(this)
                val dialog = builderP.create()
                dialog.setTitle("Confirmation")
                dialog.setMessage("Are you sure you want to delete ${selectedItem?.first} ?")
                dialog.setButton(AlertDialog.BUTTON_POSITIVE, "Yes") { dialog, which ->
                    dataList = dataList.filter { it.first != selectedItem?.first }
                    adapter.updateData(dataList)
                    adapter.notifyDataSetChanged()
                    Toast.makeText(applicationContext, selectedItem!!.first+" deleted ", Toast.LENGTH_SHORT).show()
                    fab.isVisible = false
                    selectedItem = null
                }
                dialog.setButton(AlertDialog.BUTTON_NEGATIVE, "No") { dialog, which ->
                    selectedItem = null
                    Toast.makeText(applicationContext, "Canceled", Toast.LENGTH_SHORT).show()
                    fab.isVisible = false

                    dialog.dismiss()
                }
                dialog.show()

            }
        }
    }

}