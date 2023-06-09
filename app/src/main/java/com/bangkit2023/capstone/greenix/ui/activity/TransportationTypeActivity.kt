package com.bangkit2023.capstone.greenix.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bangkit2023.capstone.greenix.data.Food
import com.bangkit2023.capstone.greenix.data.Transportation
import com.bangkit2023.capstone.greenix.databinding.ActivityTransportationTypeBinding

class TransportationTypeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTransportationTypeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTransportationTypeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        onClick()
    }

    private fun onClick() {

        binding.itemCar.setOnClickListener {
            startTransportationActivity("Car")
        }

        binding.itemMotorcycle.setOnClickListener {
            startTransportationActivity("Motorcycle")
        }

        binding.itemBus.setOnClickListener {
            startTransportationActivity("Bus")
        }
    }

    private fun startTransportationActivity(transportationType: String) {
        val selectedItem = Transportation.listTransportations.find { it.name == transportationType }
        if (selectedItem != null) {
            val intent = Intent(this@TransportationTypeActivity, TransportationActivity::class.java)
            intent.putExtra("title", selectedItem.name)
            intent.putExtra("carbon", selectedItem.carbon)
            startActivity(intent)
            finish()
        } else {
            Toast.makeText(this@TransportationTypeActivity, "Invalid Transportation Type", Toast.LENGTH_SHORT).show()
        }
    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        val intent = Intent(this, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        startActivity(intent)
        finish()
    }
}