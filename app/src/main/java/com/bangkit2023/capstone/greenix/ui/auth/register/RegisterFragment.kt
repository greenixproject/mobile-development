package com.bangkit2023.capstone.greenix.ui.auth.register

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.bangkit2023.capstone.greenix.databinding.FragmentRegisterBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class RegisterFragment : Fragment() {
    private var _fragmentRegisterBinding: FragmentRegisterBinding? = null
    private val fragmentRegisterBinding get() = _fragmentRegisterBinding!!

    private lateinit var auth: FirebaseAuth
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        _fragmentRegisterBinding = FragmentRegisterBinding.inflate(inflater, container, false)

        onClick()
        setAnimation()

        return fragmentRegisterBinding.root
    }

    private fun onClick() {
        fragmentRegisterBinding.btnRegister.setOnClickListener {
            setupRegister()
        }
        fragmentRegisterBinding.btnLogin.setOnClickListener {
            val action = RegisterFragmentDirections.actionRegisterFragmentToLoginFragment()
            findNavController().navigate(action)
        }
    }

    private fun setupRegister() {
        auth = Firebase.auth

        val name = fragmentRegisterBinding.etName.text.toString()
        val email = fragmentRegisterBinding.etEmail.text.toString()
        val password = fragmentRegisterBinding.etPassword.text.toString()
        val confirmPassword = fragmentRegisterBinding.etConfirm.text.toString()

        if (name.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty() && confirmPassword.isNotEmpty()) {
            if (password == confirmPassword) {
                auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener{
                    if (it.isSuccessful) {
                        val action = RegisterFragmentDirections.actionRegisterFragmentToLoginFragment()
                        findNavController().navigate(action)
                    } else {
                        Toast.makeText(requireActivity(), it.exception.toString(), Toast.LENGTH_SHORT).show()
                    }
                }
            } else {
                Toast.makeText(requireActivity(), "Password is not match!", Toast.LENGTH_SHORT).show()
            }
        } else {
            Toast.makeText(requireActivity(), "Empty Field is not allowed!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun setAnimation() {
        val tvTitle = ObjectAnimator.ofFloat(fragmentRegisterBinding.tvTitle, View.ALPHA, 1f).setDuration(500)
        val tvName = ObjectAnimator.ofFloat(fragmentRegisterBinding.tvName,View.ALPHA, 1f).setDuration(500)
        val etName = ObjectAnimator.ofFloat(fragmentRegisterBinding.etName,View.ALPHA, 1f).setDuration(500)
        val tvEmail = ObjectAnimator.ofFloat(fragmentRegisterBinding.tvEmail, View.ALPHA, 1f).setDuration(500)
        val etEmail = ObjectAnimator.ofFloat(fragmentRegisterBinding.etEmail, View.ALPHA, 1f).setDuration(500)
        val tvPassword = ObjectAnimator.ofFloat(fragmentRegisterBinding.tvPassword, View.ALPHA, 1f).setDuration(500)
        val etPassword = ObjectAnimator.ofFloat(fragmentRegisterBinding.etPassword, View.ALPHA, 1f).setDuration(500)
        val tvConfirm = ObjectAnimator.ofFloat(fragmentRegisterBinding.tvConfirm, View.ALPHA, 1f).setDuration(500)
        val etConfirm = ObjectAnimator.ofFloat(fragmentRegisterBinding.etConfirm, View.ALPHA, 1f).setDuration(500)
        val btnRegister = ObjectAnimator.ofFloat(fragmentRegisterBinding.btnRegister,View.ALPHA, 1f).setDuration(500)
        val btnLogin = ObjectAnimator.ofFloat(fragmentRegisterBinding.btnLogin, View.ALPHA, 1f).setDuration(500)
        val bottomtext = ObjectAnimator.ofFloat(fragmentRegisterBinding.bottomtext, View.ALPHA, 1f).setDuration(500)

        AnimatorSet().apply {
            playSequentially(
                tvTitle,
                tvName,
                etName,
                tvEmail,
                etEmail,
                tvPassword,
                etPassword,
                tvConfirm,
                etConfirm,
                btnRegister,
                btnLogin,
                bottomtext
            )
            start()
        }
    }
}