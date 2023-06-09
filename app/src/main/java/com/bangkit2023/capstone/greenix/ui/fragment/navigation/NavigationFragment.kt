package com.bangkit2023.capstone.greenix.ui.fragment.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bangkit2023.capstone.greenix.R
import com.bangkit2023.capstone.greenix.databinding.FragmentNavigationBinding
import com.bangkit2023.capstone.greenix.ui.fragment.BottomSheetFragment
import com.bangkit2023.capstone.greenix.ui.fragment.adapter.NavigationPagerAdapter

class NavigationFragment : Fragment() {
    private var _fragmentNavigationBinding: FragmentNavigationBinding? = null
    private val fragmentNavigationBinding get() = _fragmentNavigationBinding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        _fragmentNavigationBinding = FragmentNavigationBinding.inflate(inflater, container, false)
        return fragmentNavigationBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        selectedNavigationView()
    }

    private fun selectedNavigationView() {
        val adapter = NavigationPagerAdapter(requireActivity())
        fragmentNavigationBinding.viewPager.adapter = adapter

        fragmentNavigationBinding.bottomNav.setOnItemSelectedListener {
            when(it.itemId){
                R.id.btn_home -> fragmentNavigationBinding.viewPager.currentItem = 0
                R.id.btn_activity -> fragmentNavigationBinding.viewPager.currentItem = 1
                R.id.btn_article -> fragmentNavigationBinding.viewPager.currentItem = 2
                R.id.btn_more -> fragmentNavigationBinding.viewPager.currentItem = 3
            }
            true
        }

        fragmentNavigationBinding.fab.setOnClickListener {
            val bottomSheetDialog = BottomSheetFragment()
            bottomSheetDialog.show(parentFragmentManager, "Bottom Sheet Dialog")
        }
    }
}