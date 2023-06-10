package com.bangkit2023.capstone.greenix.ui.auth.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bangkit2023.capstone.greenix.databinding.FragmentLoginBinding
import com.bangkit2023.capstone.greenix.utils.AnimationUtil
import com.google.firebase.auth.FirebaseAuth

class LoginFragment : Fragment() {
    private var _fragmentLoginBinding: FragmentLoginBinding? = null
    private val fragmentLoginBinding get() = _fragmentLoginBinding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        _fragmentLoginBinding = FragmentLoginBinding.inflate(inflater, container, false)
        return fragmentLoginBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        onClick()
        setAnimation()
    }

    private fun onClick() {
        //Register Button
        fragmentLoginBinding.btnRegister.setOnClickListener {
            val action = LoginFragmentDirections.actionLoginFragmentToRegisterFragment()
            findNavController().navigate(action)
        }

        //Login Button
        fragmentLoginBinding.btnLogin.setOnClickListener {
            setupLogin()
        }
    }

    private fun setupLogin() {
        val auth = FirebaseAuth.getInstance()

        val email = fragmentLoginBinding.etEmail.text?.trim().toString()
        val password = fragmentLoginBinding.etPassword.text?.trim().toString()

        if (email.isNotEmpty() && password.isNotEmpty()) {
            auth.signInWithEmailAndPassword(email,password).addOnCompleteListener {
                if (it.isSuccessful) {
                    val action = LoginFragmentDirections.actionLoginFragmentToNavigationFragment()
                    findNavController().navigate(action)
                    Toast.makeText(requireActivity(), "Login Success", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(requireActivity(), it.exception.toString(), Toast.LENGTH_SHORT).show()
                }
            }
        } else {
            Toast.makeText(requireActivity(), "Empty Field is Not Allowed!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun setAnimation() {
        AnimationUtil.playAnimation(
            fragmentLoginBinding.tvTitle,
            fragmentLoginBinding.tvEmail,
            fragmentLoginBinding.etEmail,
            fragmentLoginBinding.tvPassword,
            fragmentLoginBinding.etPassword,
            fragmentLoginBinding.btnLogin,
            fragmentLoginBinding.bottomText,
        )
    }
}
