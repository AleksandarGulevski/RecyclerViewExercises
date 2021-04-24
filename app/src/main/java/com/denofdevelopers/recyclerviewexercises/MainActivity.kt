package com.denofdevelopers.recyclerviewexercises

import android.app.Dialog
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.Window
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.denofdevelopers.recyclerviewexercises.databinding.ActivityMainBinding
import com.denofdevelopers.recyclerviewexercises.databinding.PopupEditItemBinding

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
        val dialogBinding: PopupEditItemBinding =
            PopupEditItemBinding.inflate(
                LayoutInflater.from(this)
            )
        val dialog = Dialog(this)
        val itemNameEdit = dialogBinding.itemNameEdit
        val save = dialogBinding.save
        val cancel = dialogBinding.cancel

        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(dialogBinding.root)
        dialog.window?.setLayout(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.WRAP_CONTENT
        )

        save.setOnClickListener {
            if (!TextUtils.isEmpty(itemNameEdit.text.toString())) {
                adapter.updateItem(position, itemNameEdit.text.toString())
                dialog.dismiss()
            } else {
                Toast.makeText(this, "Please enter a new name", Toast.LENGTH_SHORT).show()
            }
        }

        cancel.setOnClickListener {
            dialog.dismiss()
        }

        dialog.show()
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