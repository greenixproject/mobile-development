package com.bangkit2023.capstone.greenix.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bangkit2023.capstone.greenix.databinding.FragmentBottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BottomSheetFragment : BottomSheetDialogFragment() {

    private var _fragmentBottomSheetBinding: FragmentBottomSheetBinding? = null
    private val fragmentBottomSheetBinding get() = _fragmentBottomSheetBinding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _fragmentBottomSheetBinding = FragmentBottomSheetBinding.inflate(inflater, container, false)
        return fragmentBottomSheetBinding.root
    }
}