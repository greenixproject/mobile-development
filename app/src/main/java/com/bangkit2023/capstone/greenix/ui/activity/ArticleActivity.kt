package com.bangkit2023.capstone.greenix.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.bangkit2023.capstone.greenix.R
import com.bangkit2023.capstone.greenix.adapter.ListArticleAdapter
import com.bangkit2023.capstone.greenix.data.Article
import com.bangkit2023.capstone.greenix.databinding.ActivityArticleBinding

class ArticleActivity : AppCompatActivity() {
    private lateinit var binding: ActivityArticleBinding

    private val list = ArrayList<Article>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityArticleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvListArticle

        list.addAll(getListArticle())
        showRecyclerList()
    }

    private fun getListArticle(): ArrayList<Article> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.getStringArray(R.array.data_photo)
        val dataDate = resources.getStringArray(R.array.data_date)

        val listArticle = ArrayList<Article>()

        for (i in dataName.indices) {
            val article = Article(dataName[i], dataDescription[i], dataPhoto[i], dataDate[i])
            listArticle.add(article)
        }

        return listArticle
    }

    private fun showRecyclerList() {
        binding.rvListArticle.layoutManager = LinearLayoutManager(this)
        val listArticleAdapter = ListArticleAdapter(list)
        binding.rvListArticle.adapter = listArticleAdapter

        listArticleAdapter.setOnItemClickCallback(object : ListArticleAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Article) {
                showSelectedBerita(data)
            }
        })
    }

    private fun showSelectedBerita(berita: Article) {
        Toast.makeText(this, "Kamu memilih " + berita.article, Toast.LENGTH_SHORT).show()
    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        val intent = Intent(this, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        startActivity(intent)
        finish()
    }
}