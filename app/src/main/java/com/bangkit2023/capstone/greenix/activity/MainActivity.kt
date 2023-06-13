package com.bangkit2023.capstone.greenix.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bangkit2023.capstone.greenix.databinding.ActivityBottomSheetTypeBinding
import com.bangkit2023.capstone.greenix.databinding.ActivityMainBinding
import com.google.android.material.bottomsheet.BottomSheetDialog

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    private var bottomSheetDialog: BottomSheetDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        onClick()
    }

    private fun onClick() {
        binding.fab.setOnClickListener {
            bottomSheetDialog()
        }
    }

    private fun bottomSheetDialog() {
        val bottomSheetDialog = BottomSheetDialog(this)
        val binding = ActivityBottomSheetTypeBinding.inflate(layoutInflater)
        bottomSheetDialog.setContentView(binding.root)

        binding.itemTransportations.setOnClickListener {
            val intent = Intent(this@MainActivity, TransportationsActivity::class.java)
            startActivity(intent)
        }

        binding.itemFoods.setOnClickListener {
            val intent = Intent(this@MainActivity, FoodsActivity::class.java)
            startActivity(intent)
        }
        bottomSheetDialog.show()
    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        if (bottomSheetDialog != null && bottomSheetDialog!!.isShowing) {
            bottomSheetDialog?.dismiss()
        } else {
            super.onBackPressed()
        }
    }
}