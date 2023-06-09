package com.bangkit2023.capstone.greenix.ui.auth.register

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.bangkit2023.capstone.greenix.databinding.FragmentRegisterBinding
import com.bangkit2023.capstone.greenix.utils.AnimationUtil
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
        AnimationUtil.playAnimation(
            fragmentRegisterBinding.tvTitle,
            fragmentRegisterBinding.tvName,
            fragmentRegisterBinding.etName,
            fragmentRegisterBinding.tvEmail,
            fragmentRegisterBinding.etEmail,
            fragmentRegisterBinding.tvPassword,
            fragmentRegisterBinding.etPassword,
            fragmentRegisterBinding.tvConfirm,
            fragmentRegisterBinding.etConfirm,
            fragmentRegisterBinding.btnRegister,
            fragmentRegisterBinding.btnLogin,
            fragmentRegisterBinding.bottomText,
        )
    }
}