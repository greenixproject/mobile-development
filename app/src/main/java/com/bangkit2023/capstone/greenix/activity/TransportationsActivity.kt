package com.bangkit2023.capstone.greenix.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bangkit2023.capstone.greenix.databinding.ActivityTransporationsBinding

class TransportationsActivity : AppCompatActivity() {
    private var _binding: ActivityTransporationsBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityTransporationsBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}