package com.bangkit2023.capstone.greenix.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bangkit2023.capstone.greenix.databinding.ActivityFoodsBinding

class FoodsActivity : AppCompatActivity() {
    private var _binding: ActivityFoodsBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityFoodsBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}