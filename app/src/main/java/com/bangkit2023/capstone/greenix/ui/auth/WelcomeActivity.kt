package com.bangkit2023.capstone.greenix.ui.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bangkit2023.capstone.greenix.databinding.ActivityWelcomeBinding
import com.bangkit2023.capstone.greenix.ui.activity.MainActivity
import com.bangkit2023.capstone.greenix.ui.auth.login.LoginActivity
import com.bangkit2023.capstone.greenix.ui.auth.register.RegisterActivity
import com.bangkit2023.capstone.greenix.utils.AnimationUtil
import com.google.firebase.auth.FirebaseAuth

class WelcomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWelcomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        onClick()
        setAnimation()
    }

    private fun onClick() {
        binding.welcomeBtnLogin.setOnClickListener {
            val intent = Intent(this@WelcomeActivity, LoginActivity::class.java)
            startActivity(intent)
        }

        binding.welcomeBtnRegister.setOnClickListener {
            val intent = Intent(this@WelcomeActivity, RegisterActivity::class.java)
            startActivity(intent)
        }
    }

    private fun setAnimation() {
        AnimationUtil.playAnimation(
            binding.logo,
            binding.title,
            binding.subTitle,
            binding.welcomeBtnLogin,
            binding.tvAccount,
            binding.welcomeBtnRegister,
        )
    }
}