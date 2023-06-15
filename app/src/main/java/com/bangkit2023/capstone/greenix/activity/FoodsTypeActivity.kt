package com.bangkit2023.capstone.greenix.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bangkit2023.capstone.greenix.data.Food
import com.bangkit2023.capstone.greenix.databinding.ActivityFoodsTypeBinding

class FoodsTypeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFoodsTypeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFoodsTypeBinding.inflate(layoutInflater)

        onClick()

        setContentView(binding.root)
    }

    private fun onClick() {
        binding.itemOil.setOnClickListener {
            startFoodsActivity("Oil")
        }

        binding.itemRice.setOnClickListener {
            startFoodsActivity("Rice")
        }

        binding.itemMeat.setOnClickListener {
            startFoodsActivity("Meat")
        }
    }

    private fun startFoodsActivity(foodType: String) {
        val selectedItem = Food.listFoods.find { it.name == foodType }
        if (selectedItem != null) {
            val intent = Intent(this@FoodsTypeActivity, FoodsActivity::class.java)
            intent.putExtra("title", selectedItem.name)
            intent.putExtra("carbon", selectedItem.carbon)
            startActivity(intent)
        } else {
            Toast.makeText(this@FoodsTypeActivity, "Invalid food type", Toast.LENGTH_SHORT).show()
        }
    }
}