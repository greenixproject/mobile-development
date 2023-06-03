package com.bangkit2023.capstone.greenix.ui.auth

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.bangkit2023.capstone.greenix.databinding.FragmentWelcomeBinding
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
            val action = WelcomeFragmentDirections.actionWelcomeFragmentToHomeFragment()
            findNavController().navigate(action)
        }
    }

    private fun setAnimation() {
        val logo = ObjectAnimator.ofFloat(fragmentWelcomeBinding.logo, View.ALPHA, 1f).setDuration(500)
        val title = ObjectAnimator.ofFloat(fragmentWelcomeBinding.title, View.ALPHA, 1f).setDuration(500)
        val subTitle = ObjectAnimator.ofFloat(fragmentWelcomeBinding.subTitle, View.ALPHA, 1f).setDuration(500)
        val welcomeBtnLogin = ObjectAnimator.ofFloat(fragmentWelcomeBinding.welcomeBtnLogin, View.ALPHA, 1f).setDuration(500)
        val imgOr = ObjectAnimator.ofFloat(fragmentWelcomeBinding.imgOr, View.ALPHA, 1f).setDuration(500)
        val welcomeBtnRegister = ObjectAnimator.ofFloat(fragmentWelcomeBinding.welcomeBtnRegister, View.ALPHA, 1f).setDuration(500)

        AnimatorSet().apply {
            playSequentially(
                logo,
                title,
                subTitle,
                welcomeBtnLogin,
                imgOr,
                welcomeBtnRegister
            )
            start()
        }
    }
}