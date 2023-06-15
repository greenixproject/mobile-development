package com.bangkit2023.capstone.greenix.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
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
            val intent = Intent(this@FoodsTypeActivity, FoodsActivity::class.java)
            startActivity(intent)
        }

        binding.itemRice.setOnClickListener {
            val intent = Intent(this@FoodsTypeActivity, FoodsActivity::class.java)
            startActivity(intent)
        }

        binding.itemMeat.setOnClickListener {
            val intent = Intent(this@FoodsTypeActivity, FoodsActivity::class.java)
            startActivity(intent)
        }
    }
}