package com.bangkit2023.capstone.greenix.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bangkit2023.capstone.greenix.databinding.ActivityArticleBinding

class ArticleActivity : AppCompatActivity() {
    private lateinit var binding: ActivityArticleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityArticleBinding.inflate(layoutInflater)

        onClick()

        setContentView(binding.root)
    }

    private fun onClick() {
        binding.cvArticle.setOnClickListener {
            val intent = Intent(this@ArticleActivity, ArticleDetailActivity::class.java)
            startActivity(intent)
        }
    }
}