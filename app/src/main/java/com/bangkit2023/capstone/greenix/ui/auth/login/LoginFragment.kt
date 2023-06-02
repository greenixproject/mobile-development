package com.bangkit2023.capstone.greenix.ui.auth.login

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.bangkit2023.capstone.greenix.databinding.FragmentLoginBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginFragment : Fragment() {
    private var _fragmentLoginBinding: FragmentLoginBinding? = null
    private val fragmentLoginBinding get() = _fragmentLoginBinding!!


    private lateinit var auth: FirebaseAuth

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        _fragmentLoginBinding = FragmentLoginBinding.inflate(inflater, container, false)

        onClick()
        setAnimation()

        return fragmentLoginBinding.root
    }

    private fun onClick() {
        //Login Button
        fragmentLoginBinding.btnLogin.setOnClickListener {
            setupLogin()
        }

        //Register Button
        fragmentLoginBinding.btnRegister.setOnClickListener {
            val action = LoginFragmentDirections.actionLoginFragmentToRegisterFragment()
            findNavController().navigate(action)
        }
    }

    private fun setupLogin() {
        auth = Firebase.auth

        val email = fragmentLoginBinding.etEmail.toString()
        val password = fragmentLoginBinding.etPassword.toString()

        if (email.isNotEmpty() && password.isNotEmpty()) {
            auth.signInWithEmailAndPassword(email,password).addOnCompleteListener {
                if (it.isSuccessful) {
                    val action = LoginFragmentDirections.actionLoginFragmentToHomeFragment()
                    findNavController().navigate(action)
                } else {
                    Toast.makeText(requireActivity(), it.exception.toString(), Toast.LENGTH_SHORT).show()
                }
            }

        } else {
            Toast.makeText(requireActivity(), "Empty Field is not allowed!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun setAnimation() {
        val tvTitle = ObjectAnimator.ofFloat(fragmentLoginBinding.tvTitle, View.ALPHA, 1f).setDuration(500)
        val tvEmail = ObjectAnimator.ofFloat(fragmentLoginBinding.tvEmail, View.ALPHA, 1f).setDuration(500)
        val etEmail = ObjectAnimator.ofFloat(fragmentLoginBinding.etEmail, View.ALPHA, 1f).setDuration(500)
        val tvPassword = ObjectAnimator.ofFloat(fragmentLoginBinding.tvPassword, View.ALPHA, 1f).setDuration(500)
        val etPassword = ObjectAnimator.ofFloat(fragmentLoginBinding.etPassword, View.ALPHA, 1f).setDuration(500)
        val btnLogin = ObjectAnimator.ofFloat(fragmentLoginBinding.btnLogin, View.ALPHA, 1f).setDuration(500)
        val bottomtext = ObjectAnimator.ofFloat(fragmentLoginBinding.bottomtext, View.ALPHA, 1f).setDuration(500)

        AnimatorSet().apply {
            playSequentially(
                tvTitle,
                tvEmail,
                etEmail,
                tvPassword,
                etPassword,
                btnLogin,
                bottomtext
            )
            start()
        }
    }
}
