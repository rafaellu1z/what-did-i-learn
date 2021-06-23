package com.devventure.whatdidilearn.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.devventure.whatdidilearn.WhatDidILearnApplication
import com.devventure.whatdidilearn.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val recyclerView = binding.learnedItemsRecyclerView
        val adapter = LearnedItemAdapter()

        val database = (application as WhatDidILearnApplication).database
        val items = database.learnedItemDao().getAll()

        items.observe(this, {
                adapter.learnedItems = it
            }
        )

        recyclerView.adapter = adapter

        binding.floatingActionButtonAddItem.setOnClickListener {
            val intent = Intent(this, NewItemActivity::class.java)
            startActivity(intent)
        }

    }
}