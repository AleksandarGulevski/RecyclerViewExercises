package com.denofdevelopers.recyclerviewexercises

import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.children
import androidx.core.view.get
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.denofdevelopers.recyclerviewexercises.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), ItemAdapter.ItemClickListener {

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

    override fun onItemClickListener(item: Item, position: Int) {
        val itemBackground: ColorDrawable =
            binding.recycler[position].background as ColorDrawable
        if (itemBackground.color == ContextCompat.getColor(this, R.color.white)) {
            binding.recycler.children.iterator().forEach { item ->
                item.setBackgroundColor(
                    ContextCompat.getColor(
                        this,
                        R.color.white
                    )
                )
            }
            binding.recycler[position].setBackgroundColor(
                ContextCompat.getColor(this, R.color.teal_200)
            )
        } else {
            binding.recycler.children.iterator().forEach { item ->
                item.setBackgroundColor(
                    ContextCompat.getColor(
                        this,
                        R.color.white
                    )
                )
            }
        }
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