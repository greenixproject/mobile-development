package com.bangkit2023.capstone.greenix.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bangkit2023.capstone.greenix.databinding.ActivityProfileBinding
import com.bangkit2023.capstone.greenix.utils.AnimationUtil

class ProfileActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setAnimation()
        onClick()
    }

    private fun onClick() {
        binding.btnSubmit.setOnClickListener {
            //Simpan
        }
    }

    private fun setAnimation() {
        AnimationUtil.playAnimation(
            binding.imgAvatar,
            binding.tvUsername,
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