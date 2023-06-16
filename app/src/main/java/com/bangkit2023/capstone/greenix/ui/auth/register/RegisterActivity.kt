package com.bangkit2023.capstone.greenix.ui.auth.register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bangkit2023.capstone.greenix.databinding.ActivityRegisterBinding
import com.bangkit2023.capstone.greenix.ui.auth.login.LoginActivity
import com.bangkit2023.capstone.greenix.utils.AnimationUtil
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)

        onClick()
        setAnimation()

        setContentView(binding.root)
    }

    private fun onClick() {
        binding.btnRegister.setOnClickListener {
            setupRegister()
        }
        binding.btnLogin.setOnClickListener {
            val intent = Intent(this@RegisterActivity, LoginActivity::class.java)
            startActivity(intent)
        }
    }

    private fun setupRegister() {
        auth = Firebase.auth

        val name = binding.etName.text.toString()
        val email = binding.etEmail.text.toString()
        val password = binding.etPassword.text.toString()
        val confirmPassword = binding.etConfirm.text.toString()

        if (name.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty() && confirmPassword.isNotEmpty()) {
            if (password == confirmPassword) {
                auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener{
                    if (it.isSuccessful) {
                        val intent = Intent(this@RegisterActivity, LoginActivity::class.java)
                        startActivity(intent)
                    } else {
                        Toast.makeText(this@RegisterActivity, it.exception.toString(), Toast.LENGTH_SHORT).show()
                    }
                }
            } else {
                Toast.makeText(this@RegisterActivity, "Password is not match!", Toast.LENGTH_SHORT).show()
            }
        } else {
            Toast.makeText(this@RegisterActivity, "Empty Field is not allowed!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun setAnimation() {
        AnimationUtil.playAnimation(
            binding.tvTitle,
            binding.tvName,
            binding.etName,
            binding.tvEmail,
            binding.etEmail,
            binding.tvPassword,
            binding.etPassword,
            binding.tvConfirm,
            binding.etConfirm,
            binding.btnRegister,
            binding.btnLogin,
            binding.bottomText,
        )
    }
}