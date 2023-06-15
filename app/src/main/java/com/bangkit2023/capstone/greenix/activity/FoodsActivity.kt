package com.bangkit2023.capstone.greenix.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bangkit2023.capstone.greenix.databinding.ActivityFoodsBinding

class FoodsActivity : AppCompatActivity() {
    private var _binding: ActivityFoodsBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityFoodsBinding.inflate(layoutInflater)

        getFoodTitle()
        onClick()

        setContentView(binding.root)
    }

    private fun onClick() {
        binding.btnCalculateFood.setOnClickListener {
            calculate()
        }
    }

    private fun getFoodTitle() {
        val title = intent.getStringExtra("title")
        binding.tvTitle.text = title
    }

    private fun calculate() {
        val etPeople = binding.etPeople.text.toString().toFloatOrNull()
        val etAmount = binding.etAmount.text.toString().toFloatOrNull()
        val carbonValue = intent.getFloatExtra("carbon", 0F)

        if (etPeople != null && etAmount != null) {
            val calculate = etAmount / etPeople
            val result = calculate * carbonValue
            val format = String.format("%.1f", result)
            val intent = Intent(this@FoodsActivity, MainActivity::class.java)
            intent.putExtra("result", format)
            startActivity(intent)
        } else {
            Toast.makeText(this@FoodsActivity, "Error calculating", Toast.LENGTH_SHORT).show()
        }
    }
}