package com.bangkit2023.capstone.greenix.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.bangkit2023.capstone.greenix.databinding.FragmentHomeBinding
import com.google.firebase.auth.FirebaseAuth

class HomeFragment : Fragment() {

    private var _fragmentHomeBinding: FragmentHomeBinding? = null
    private val fragmentHomeBinding get() = _fragmentHomeBinding!!


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        _fragmentHomeBinding = FragmentHomeBinding.inflate(inflater, container, false)

        onClick()

        return fragmentHomeBinding.root
    }

    private fun onClick() {
        fragmentHomeBinding.btnLogout.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            val action = HomeFragmentDirections.actionHomeFragmentToLoginFragment()
            findNavController().navigate(action)
        }
    }
}