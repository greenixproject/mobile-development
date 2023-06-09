package com.bangkit2023.capstone.greenix.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bangkit2023.capstone.greenix.databinding.FragmentArticleBinding

class ArticleFragment : Fragment() {

    private var _fragmentArticleBinding: FragmentArticleBinding? = null
    private val fragmentArticleBinding get() = _fragmentArticleBinding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _fragmentArticleBinding = FragmentArticleBinding.inflate(inflater, container, false)

        return fragmentArticleBinding.root
    }


}