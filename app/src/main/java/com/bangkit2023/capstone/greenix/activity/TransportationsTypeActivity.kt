package com.bangkit2023.capstone.greenix.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bangkit2023.capstone.greenix.databinding.ActivityTransportationsTypeBinding

class TransportationsTypeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTransportationsTypeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTransportationsTypeBinding.inflate(layoutInflater)

        onClick()

        setContentView(binding.root)
    }

    private fun onClick() {
        binding.itemCar.setOnClickListener {
            val intent = Intent(this@TransportationsTypeActivity, TransportationsActivity::class.java)
            startActivity(intent)
        }

        binding.itemMotorcycle.setOnClickListener {
            val intent = Intent(this@TransportationsTypeActivity, TransportationsActivity::class.java)
            startActivity(intent)
        }

        binding.itemBus.setOnClickListener {
            val intent = Intent(this@TransportationsTypeActivity, TransportationsActivity::class.java)
            startActivity(intent)
        }
    }
}