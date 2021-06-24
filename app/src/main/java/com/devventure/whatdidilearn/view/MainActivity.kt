package com.devventure.whatdidilearn.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.devventure.whatdidilearn.databinding.ActivityMainBinding
import com.devventure.whatdidilearn.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val recyclerView = binding.learnedItemsRecyclerView
        val adapter = LearnedItemAdapter()
        recyclerView.adapter = adapter

        /*val repository = (application as WhatDidILearnApplication).repository
        val viewModelFactory = ViewModelFactory(repository)
        val viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)*/

        val items = viewModel.learnedItems
        items.observe(this, Observer {
                adapter.learnedItems = it
            }
        )

        binding.floatingActionButtonAddItem.setOnClickListener {
            val intent = Intent(this, NewItemActivity::class.java)
            startActivity(intent)
        }
    }
}