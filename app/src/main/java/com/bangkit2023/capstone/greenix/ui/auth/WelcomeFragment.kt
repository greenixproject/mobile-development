package com.bangkit2023.capstone.greenix.ui.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bangkit2023.capstone.greenix.databinding.FragmentWelcomeBinding

class WelcomeFragment : Fragment() {
    private var _fragmentWelcomeBinding: FragmentWelcomeBinding? = null
    private val fragmentWelcomeBinding get() = _fragmentWelcomeBinding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        _fragmentWelcomeBinding = FragmentWelcomeBinding.inflate(inflater, container, false)
        return fragmentWelcomeBinding.root
    }
}