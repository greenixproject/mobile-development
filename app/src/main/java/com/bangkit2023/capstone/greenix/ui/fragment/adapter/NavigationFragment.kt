package com.bangkit2023.capstone.greenix.ui.fragment.adapter

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bangkit2023.capstone.greenix.R
import com.bangkit2023.capstone.greenix.databinding.FragmentNavigationBinding
import com.bangkit2023.capstone.greenix.ui.fragment.BottomSheetFragment

class NavigationFragment : Fragment() {

    private var _fragmentNavigationBinding: FragmentNavigationBinding? = null
    private val fragmentNavigationBinding get() = _fragmentNavigationBinding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _fragmentNavigationBinding = FragmentNavigationBinding.inflate(inflater, container, false)
        selectedNavigationView()
        return fragmentNavigationBinding.root
    }

    private fun selectedNavigationView() {
        val adapter = NavigationPagerAdapter(requireActivity())
        fragmentNavigationBinding.viewPager.adapter = adapter
        fragmentNavigationBinding.bottomNav.setOnItemSelectedListener {
            when(it.itemId){
                R.id.btn_home -> fragmentNavigationBinding.viewPager.setCurrentItem(0)
                R.id.btn_activity -> fragmentNavigationBinding.viewPager.setCurrentItem(1)
                R.id.btn_article -> fragmentNavigationBinding.viewPager.setCurrentItem(2)
                R.id.btn_more -> fragmentNavigationBinding.viewPager.setCurrentItem(3)
            }
            true
        }

        fragmentNavigationBinding.fab.setOnClickListener {
            val bottomSheetDialog = BottomSheetFragment()
            bottomSheetDialog.show(parentFragmentManager, "Bottom Sheet Dialog")
        }
    }
}