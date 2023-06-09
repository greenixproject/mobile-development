package com.bangkit2023.capstone.greenix.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.bangkit2023.capstone.greenix.R
import com.bangkit2023.capstone.greenix.databinding.FragmentMenuBinding
import com.google.firebase.auth.FirebaseAuth

class MenuFragment : Fragment() {
    private var _fragmentMenuBinding: FragmentMenuBinding? = null
    private val fragmentMenuBinding get() = _fragmentMenuBinding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        _fragmentMenuBinding = FragmentMenuBinding.inflate(inflater, container, false)
        return fragmentMenuBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onClick()
    }

    private fun onClick() {
        fragmentMenuBinding.btnLogout.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            findNavController().navigate(R.id.welcomeFragment)
        }
    }
}