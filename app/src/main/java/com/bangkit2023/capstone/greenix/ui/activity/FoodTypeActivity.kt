package com.bangkit2023.capstone.greenix.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bangkit2023.capstone.greenix.data.Food
import com.bangkit2023.capstone.greenix.databinding.ActivityFoodTypeBinding

class FoodTypeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFoodTypeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFoodTypeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        onClick()
    }

    private fun onClick() {

        binding.itemOil.setOnClickListener {
            startFoodActivity("Oil")
        }

        binding.itemRice.setOnClickListener {
            startFoodActivity("Rice")
        }

        binding.itemMeat.setOnClickListener {
            startFoodActivity("Meat")
        }
    }

    private fun startFoodActivity(foodType: String) {
        val selectedItem = Food.listFoods.find { it.name == foodType }
        if (selectedItem != null) {
            val intent = Intent(this@FoodTypeActivity, FoodActivity::class.java)
            intent.putExtra("title", selectedItem.name)
            intent.putExtra("carbon", selectedItem.carbon)
            startActivity(intent)

            finish()

        } else {
            Toast.makeText(this@FoodTypeActivity, "Invalid Food Type", Toast.LENGTH_SHORT).show()
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