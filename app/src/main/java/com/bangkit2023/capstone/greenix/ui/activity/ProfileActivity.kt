package com.bangkit2023.capstone.greenix.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bangkit2023.capstone.greenix.databinding.ActivityProfileBinding
import com.bangkit2023.capstone.greenix.utils.AnimationUtil
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class ProfileActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val user = Firebase.auth.currentUser
        val email = user?.email

        binding.tvEmail.text = email

        setAnimation()
        onClick()
    }

    private fun onClick() {
        binding.btnSubmit.setOnClickListener {
            val intent = Intent(this@ProfileActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun setAnimation() {
        AnimationUtil.playAnimation(
            binding.imgAvatar,
            binding.tvEmail,
            binding.tvName,
            binding.etName,
            binding.tvAge,
            binding.etAge,
            binding.tvGender,
            binding.radioGroup,
            binding.tvLocation,
            binding.etLocation,
            binding.btnSubmit
        )
    }
}