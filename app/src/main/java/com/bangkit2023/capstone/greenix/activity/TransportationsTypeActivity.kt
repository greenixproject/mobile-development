package com.bangkit2023.capstone.greenix.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bangkit2023.capstone.greenix.data.Food
import com.bangkit2023.capstone.greenix.data.Transportation
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
            startTransportationsActivity("Car")
        }

        binding.itemMotorcycle.setOnClickListener {
            startTransportationsActivity("Motorcycle")
        }

        binding.itemBus.setOnClickListener {
            startTransportationsActivity("Bus")
        }
    }

    private fun startTransportationsActivity(TransporationType: String) {
        val selectedItem = Transportation.listTransportations.find { it.name == TransporationType }
        if (selectedItem != null) {
            val intent = Intent(this@TransportationsTypeActivity, TransportationsActivity::class.java)
            intent.putExtra("title", selectedItem.name)
            intent.putExtra("carbon", selectedItem.carbon)
            startActivity(intent)
        } else {
            Toast.makeText(this@TransportationsTypeActivity, "Invalid food type", Toast.LENGTH_SHORT).show()
        }
    }
}