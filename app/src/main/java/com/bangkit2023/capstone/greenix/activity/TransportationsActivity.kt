package com.bangkit2023.capstone.greenix.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bangkit2023.capstone.greenix.databinding.ActivityTransportationsBinding

class TransportationsActivity : AppCompatActivity() {
    private var _binding: ActivityTransportationsBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityTransportationsBinding.inflate(layoutInflater)

        getTransportationTitle()
        onClick()

        setContentView(binding.root)
    }

    private fun onClick() {
        binding.btnCalculateTransportation.setOnClickListener {
            calculate()
        }
    }

    private fun getTransportationTitle() {
        val title = intent.getStringExtra("title")
        binding.tvTitle.text = title
    }

    private fun calculate() {
        val etDistance = binding.etSliderCounter.text.toString().toFloatOrNull()
        val carbonValue = intent.getFloatExtra("carbon", 0F)

        if (etDistance != null) {
            val result = etDistance * carbonValue
            val format = String.format("%.1f", result)
            val intent = Intent(this@TransportationsActivity, MainActivity::class.java)
            intent.putExtra("result", format)
            startActivity(intent)
        } else {
            Toast.makeText(this@TransportationsActivity, "Error calculating", Toast.LENGTH_SHORT).show()
        }
    }
}