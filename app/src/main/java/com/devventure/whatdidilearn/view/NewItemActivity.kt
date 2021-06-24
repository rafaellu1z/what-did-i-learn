package com.devventure.whatdidilearn.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.devventure.whatdidilearn.databinding.ActivityNewItemBinding

class  NewItemActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityNewItemBinding.inflate(layoutInflater)

        setContentView(binding.root)

        supportActionBar?.title = "New Learned Item"

        binding.buttonSaveItem.setOnClickListener{
            navigateToMainActivity()
        }
    }

    private fun navigateToMainActivity(){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}