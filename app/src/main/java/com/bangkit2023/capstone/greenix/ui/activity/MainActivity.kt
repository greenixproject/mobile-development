package com.bangkit2023.capstone.greenix.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bangkit2023.capstone.greenix.R
import com.bangkit2023.capstone.greenix.databinding.ActivityBottomSheetTypeBinding
import com.bangkit2023.capstone.greenix.databinding.ActivityMainBinding
import com.bangkit2023.capstone.greenix.ui.auth.WelcomeActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        currentUser()

        val result = intent.getStringExtra("result") ?: "0"
        binding.tvCarbonSummary.text = "$result KgCO2"

        onClick()
        bottomNav()
    }

    private fun onClick() {
        //Profile Avatar
        binding.imgAvatar.setOnClickListener {
        val intent = Intent(this@MainActivity, ProfileActivity::class.java)
        startActivity(intent)
        }

        //Floating Button
        binding.fab.setOnClickListener {
            bottomSheetDialog()
        }
    }

    private fun bottomSheetDialog() {
        val bottomSheetDialog = BottomSheetDialog(this)
        val bottom = ActivityBottomSheetTypeBinding.inflate(layoutInflater)
        bottomSheetDialog.setContentView(bottom.root)

        bottom.itemTransportations.setOnClickListener {
            val intent = Intent(this@MainActivity, TransportationTypeActivity::class.java)
            startActivity(intent)
            bottomSheetDialog.dismiss()
        }

        bottom.itemFoods.setOnClickListener {
            val intent = Intent(this@MainActivity, FoodTypeActivity::class.java)
            startActivity(intent)
            bottomSheetDialog.dismiss()
        }

        bottomSheetDialog.show()
    }

    private fun bottomNav() {
        bottomNavigationView = binding.bottomNav
        bottomNavigationView.selectedItemId = R.id.btn_home

        bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.btn_home -> {
                    Toast.makeText(this@MainActivity, "Home", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.btn_activity -> {
                    val intent = Intent(this@MainActivity, ActivityPage::class.java)
                    startActivity(intent)
                    finish()

                    Toast.makeText(this@MainActivity, "Activity", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.btn_article -> {
                    val intent = Intent(this@MainActivity, ArticleActivity::class.java)
                    startActivity(intent)
                    finish()

                    Toast.makeText(this@MainActivity, "Article", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.btn_more -> {
                    val intent = Intent(this@MainActivity, MenuActivity::class.java)
                    startActivity(intent)
                    finish()

                    Toast.makeText(this@MainActivity, "Menu", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }
    }

    private fun currentUser() {
        val user = FirebaseAuth.getInstance().currentUser
        if (user == null) {
            // User is signed in
            val intent = Intent(this@MainActivity, WelcomeActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}