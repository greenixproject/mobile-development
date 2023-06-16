package com.bangkit2023.capstone.greenix.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bangkit2023.capstone.greenix.databinding.ActivityArticleDetailBinding
import com.bangkit2023.capstone.greenix.utils.AnimationUtil
import com.squareup.picasso.Picasso

class ArticleDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityArticleDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityArticleDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setAnimation()

        val tvArticle = binding.tvName
        val tvDesc = binding.tvDesc
        val imgPhoto = binding.imgArticle
        val tvDate = binding.tvDate

        val article = intent.getStringExtra(EXTRA_NEWS)
        val desc = intent.getStringExtra(EXTRA_DESC)
        val photo = intent.getStringExtra(EXTRA_PHOTO)
        val dates = intent.getStringExtra(EXTRA_DATE)

        tvArticle.text = article
        tvDesc.text = desc
        Picasso.get().load(photo).fit().centerCrop().into(imgPhoto)
        tvDate.text = dates
    }

    private fun setAnimation() {
        AnimationUtil.playAnimation(
            binding.cvArticleDetail,
            binding.tvDate,
            binding.tvName,
            binding.tvDesc
        )
    }

    companion object {
        const val EXTRA_NEWS = "extra_age"
        const val EXTRA_DESC = "extra_desc"
        const val EXTRA_PHOTO = "extra_photo"
        const val EXTRA_DATE = "extra_date"
    }
}