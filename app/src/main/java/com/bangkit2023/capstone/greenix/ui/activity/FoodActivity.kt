package com.bangkit2023.capstone.greenix.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bangkit2023.capstone.greenix.databinding.ActivityFoodBinding

class FoodActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFoodBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFoodBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getFoodTitle()
        onClick()
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
            val intent = Intent(this@FoodActivity, MainActivity::class.java)
            intent.putExtra("result", format)
            startActivity(intent)
        } else {
            Toast.makeText(this@FoodActivity, "Error calculating", Toast.LENGTH_SHORT).show()
        }
    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        val intent = Intent(this, FoodTypeActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        startActivity(intent)
        finish()
    }
}