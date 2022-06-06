package com.example.mainactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mainactivity.databinding.ActivityLastBinding
import com.example.mainactivity.databinding.ActivityMainBinding

class LastActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLastBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLastBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.visible.setOnClickListener {
            Intent(this, HomeActivity::class.java).also {
                startActivity(it)
            }
        }

    }

}