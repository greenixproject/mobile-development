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

        onClick()
        setAnimation()

        setContentView(binding.root)
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
        } else {
            Toast.makeText(this@FoodTypeActivity, "Invalid Food Type", Toast.LENGTH_SHORT).show()
        }
    }

    private fun setAnimation() {

    }
}