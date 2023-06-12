package com.bangkit2023.capstone.greenix.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bangkit2023.capstone.greenix.databinding.ActivityBottomSheetTypeBinding
import com.bangkit2023.capstone.greenix.databinding.ActivityMainBinding
import com.google.android.material.bottomsheet.BottomSheetDialog

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var bottomSheetDialog: BottomSheetDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        onClick()

        setContentView(binding.root)
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