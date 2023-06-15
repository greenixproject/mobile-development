package com.bangkit2023.capstone.greenix.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bangkit2023.capstone.greenix.databinding.ActivityBottomSheetTypeBinding
import com.bangkit2023.capstone.greenix.databinding.ActivityMainBinding
import com.google.android.material.bottomsheet.BottomSheetDialog

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val result = intent.getStringExtra("result") ?: "0"
        binding.tvCarbonSummary.text = "$result KgCO2"

        onClick()
    }

    private fun onClick() {
        binding.fab.setOnClickListener {
            bottomSheetDialog()
        }
    }

    private fun bottomSheetDialog() {
        val bottomSheetDialog = BottomSheetDialog(this)
        val bottom = ActivityBottomSheetTypeBinding.inflate(layoutInflater)
        bottomSheetDialog.setContentView(bottom.root)

        bottom.itemTransportations.setOnClickListener {
            val intent = Intent(this@MainActivity, TransportationsTypeActivity::class.java)
            startActivity(intent)
            bottomSheetDialog.dismiss()
        }

        bottom.itemFoods.setOnClickListener {
            val intent = Intent(this@MainActivity, FoodsTypeActivity::class.java)
            startActivity(intent)
            bottomSheetDialog.dismiss()
        }
        bottomSheetDialog.show()
    }
}