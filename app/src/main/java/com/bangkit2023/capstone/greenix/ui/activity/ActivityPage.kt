package com.bangkit2023.capstone.greenix.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bangkit2023.capstone.greenix.databinding.ActivityBottomSheetTypeBinding
import com.bangkit2023.capstone.greenix.databinding.ActivityPageBinding
import com.google.android.material.bottomsheet.BottomSheetDialog

class ActivityPage : AppCompatActivity() {
    private lateinit var binding: ActivityPageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        onClick()
    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        val intent = Intent(this, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        startActivity(intent)
        finish()
    }

    private fun onClick() {
        binding.btnAddActivity.setOnClickListener {
            bottomSheetDialog()
        }
    }

    private fun bottomSheetDialog() {
        val bottomSheetDialog = BottomSheetDialog(this)
        val bottom = ActivityBottomSheetTypeBinding.inflate(layoutInflater)
        bottomSheetDialog.setContentView(bottom.root)

        bottom.itemTransportations.setOnClickListener {
            val intent = Intent(this@ActivityPage, TransportationTypeActivity::class.java)
            startActivity(intent)
            bottomSheetDialog.dismiss()
        }

        bottom.itemFoods.setOnClickListener {
            val intent = Intent(this@ActivityPage, FoodTypeActivity::class.java)
            startActivity(intent)
            bottomSheetDialog.dismiss()
        }
        bottomSheetDialog.show()
    }
}