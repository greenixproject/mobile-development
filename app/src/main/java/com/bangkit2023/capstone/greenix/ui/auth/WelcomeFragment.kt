package com.bangkit2023.capstone.greenix.ui.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.bangkit2023.capstone.greenix.databinding.FragmentWelcomeBinding
import com.bangkit2023.capstone.greenix.ui.utils.AnimationUtil
import com.google.firebase.auth.FirebaseAuth

class WelcomeFragment : Fragment() {
    private var _fragmentWelcomeBinding: FragmentWelcomeBinding? = null
    private val fragmentWelcomeBinding get() = _fragmentWelcomeBinding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        _fragmentWelcomeBinding = FragmentWelcomeBinding.inflate(inflater, container, false)

        onClick()
        setAnimation()
        currentUser()

        return fragmentWelcomeBinding.root
    }

    private fun onClick() {

        fragmentWelcomeBinding.welcomeBtnLogin.setOnClickListener {
            val action = WelcomeFragmentDirections.actionWelcomeFragmentToLoginFragment()
            findNavController().navigate(action)
        }
        fragmentWelcomeBinding.welcomeBtnRegister.setOnClickListener {
            val action = WelcomeFragmentDirections.actionWelcomeFragmentToRegisterFragment()
            findNavController().navigate(action)
        }
    }

    private fun currentUser() {
        val user = FirebaseAuth.getInstance().currentUser
        if (user != null) {
            // User is signed in
            val action = WelcomeFragmentDirections.actionWelcomeFragmentToNavigationFragment()
            findNavController().navigate(action)
            Toast.makeText(requireActivity(), "Hi Welcome Back!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun setAnimation() {
        AnimationUtil.playAnimation(
            fragmentWelcomeBinding.logo,
            fragmentWelcomeBinding.title,
            fragmentWelcomeBinding.subTitle,
            fragmentWelcomeBinding.welcomeBtnLogin,
            fragmentWelcomeBinding.imgOr,
            fragmentWelcomeBinding.welcomeBtnRegister,
        )
    }
}