package com.denofdevelopers.recyclerviewexercises

import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.children
import androidx.core.view.get
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.widget.Toast
import com.denofdevelopers.recyclerviewexercises.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), ItemAdapter.OnLongCLickListener {

    private lateinit var binding: ActivityMainBinding
    private var adapter = ItemAdapter(this, this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupUi()
    }

    private fun setupUi() {
        setupRecycler()
    }

    private fun setupRecycler() {
        initRecyclerView(binding.recycler)
        binding.recycler.adapter = adapter
        adapter.addAll(getDummyList())
    }

    private fun initRecyclerView(recyclerView: RecyclerView) {
        recyclerView.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false
        )
    }

    override fun onItemLongClickListener(item: Item, position: Int) {
        Toast.makeText(this, "${item.itemName} long clicked", Toast.LENGTH_SHORT).show()
    }

    private fun getDummyList(): ArrayList<Item> {
        val items = ArrayList<Item>()
        items.add(Item("Item one"))
        items.add(Item("Item two"))
        items.add(Item("Item three"))
        items.add(Item("Item four"))
        items.add(Item("Item five"))
        items.add(Item("Item six"))
        items.add(Item("Item seven"))
        items.add(Item("Item eight"))
        items.add(Item("Item nine"))
        items.add(Item("Item ten"))
        return items
    }


}