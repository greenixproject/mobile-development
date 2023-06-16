package com.bangkit2023.capstone.greenix.ui.auth.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bangkit2023.capstone.greenix.databinding.ActivityLoginBinding
import com.bangkit2023.capstone.greenix.ui.activity.MainActivity
import com.bangkit2023.capstone.greenix.ui.auth.register.RegisterActivity
import com.bangkit2023.capstone.greenix.utils.AnimationUtil
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        onClick()
        setAnimation()
    }

    private fun onClick() {
        //Register Button
        binding.btnRegister.setOnClickListener {
            val intent = Intent(this@LoginActivity, RegisterActivity::class.java)
            startActivity(intent)
            finish()
        }

        //Login Button
        binding.btnLogin.setOnClickListener {
            setupLogin()
        }
    }

    private fun setupLogin() {
        val auth = FirebaseAuth.getInstance()

        val email = binding.etEmail.text?.trim().toString()
        val password = binding.etPassword.text?.trim().toString()

        if (email.isNotEmpty() && password.isNotEmpty()) {
            auth.signInWithEmailAndPassword(email,password).addOnCompleteListener {
                if (it.isSuccessful) {
                    val intent = Intent(this@LoginActivity, MainActivity::class.java)
                    startActivity(intent)
                    finish()

                    Toast.makeText(this@LoginActivity, "Login Success", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this@LoginActivity, it.exception.toString(), Toast.LENGTH_SHORT).show()
                }
            }
        } else {
            Toast.makeText(this@LoginActivity, "Empty Field is Not Allowed!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun setAnimation() {
        AnimationUtil.playAnimation(
            binding.tvTitle,
            binding.tvEmail,
            binding.etEmail,
            binding.tvPassword,
            binding.etPassword,
            binding.btnLogin,
            binding.bottomText,
        )
    }
}