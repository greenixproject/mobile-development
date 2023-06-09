package com.bangkit2023.capstone.greenix.ui.fragment.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.bangkit2023.capstone.greenix.ui.fragment.ActivityFragment
import com.bangkit2023.capstone.greenix.ui.fragment.ArticleFragment
import com.bangkit2023.capstone.greenix.ui.fragment.HomeFragment
import com.bangkit2023.capstone.greenix.ui.fragment.MenuFragment

class NavigationPagerAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {
    // Number of Fragments
    override fun getItemCount(): Int = 4

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> HomeFragment()
            1 -> ActivityFragment()
            2 -> ArticleFragment()
            3 -> MenuFragment()
            else -> throw IllegalArgumentException("Invalid position: $position")
        }
    }
}