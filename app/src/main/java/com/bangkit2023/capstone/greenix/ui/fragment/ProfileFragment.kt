package com.bangkit2023.capstone.greenix.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bangkit2023.capstone.greenix.databinding.FragmentProfileBinding
import com.bangkit2023.capstone.greenix.utils.AnimationUtil

class ProfileFragment : Fragment() {
    private var _fragmentProfileBinding: FragmentProfileBinding? = null
    private val fragmentProfileBinding get() = _fragmentProfileBinding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        _fragmentProfileBinding = FragmentProfileBinding.inflate(inflater, container, false)
        return fragmentProfileBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setAnimation()
    }

    private fun setAnimation() {
        AnimationUtil.playAnimation(
            fragmentProfileBinding.imgAvatar,
            fragmentProfileBinding.tvUsername,
            fragmentProfileBinding.tvEmail,
            fragmentProfileBinding.tvName,
            fragmentProfileBinding.etName,
            fragmentProfileBinding.tvAge,
            fragmentProfileBinding.etAge,
            fragmentProfileBinding.tvGender,
            fragmentProfileBinding.radioGroup,
            fragmentProfileBinding.tvLocation,
            fragmentProfileBinding.etLocation,
            fragmentProfileBinding.btnSubmit
        )
    }
}