package com.bangkit2023.capstone.greenix.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bangkit2023.capstone.greenix.databinding.FragmentActivityBinding

class ActivityFragment : Fragment() {

    private var _fragmentActivityBinding: FragmentActivityBinding? = null
    private val fragmentActivityBinding get() = _fragmentActivityBinding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _fragmentActivityBinding = FragmentActivityBinding.inflate(inflater, container, false)
        onClick()
        return fragmentActivityBinding.root
    }

    private fun onClick() {
        fragmentActivityBinding.btnAddActivity.setOnClickListener {
            val bottomSheetDialog = BottomSheetFragment()
            bottomSheetDialog.show(parentFragmentManager, "Bottom Sheet Dialog")
        }
    }
}