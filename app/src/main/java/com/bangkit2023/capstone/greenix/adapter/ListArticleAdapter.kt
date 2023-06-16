package com.bangkit2023.capstone.greenix.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bangkit2023.capstone.greenix.R
import com.bangkit2023.capstone.greenix.data.Article
import com.bangkit2023.capstone.greenix.ui.activity.ArticleDetailActivity
import com.squareup.picasso.Picasso

class ListArticleAdapter(private val listArticle: ArrayList<Article>) : RecyclerView.Adapter<ListArticleAdapter.ListViewHolder>(){
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Article)
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val cvList: CardView = itemView.findViewById(R.id.cv_article)
        val imgItemPhoto: ImageView = itemView.findViewById(R.id.img_article)
        val tvItemArticle: TextView = itemView.findViewById(R.id.tv_title)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val layout = R.layout.item_article
        val view = LayoutInflater.from(parent.context).inflate(layout, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listArticle.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val list = listArticle[position]

        val article = list.article
        val desc = list.description
        val photo = list.photo
        val date = list.date

        holder.apply {
            cvList
            tvItemArticle.text = list.article
            Picasso.get().load(photo).fit().centerCrop().into(imgItemPhoto)

            val mvDetail = Intent(holder.itemView.context, ArticleDetailActivity::class.java)
            mvDetail.putExtra(ArticleDetailActivity.EXTRA_NEWS, article)
            mvDetail.putExtra(ArticleDetailActivity.EXTRA_DESC, desc)
            mvDetail.putExtra(ArticleDetailActivity.EXTRA_PHOTO, photo)
            mvDetail.putExtra(ArticleDetailActivity.EXTRA_DATE, date)
            holder.itemView.setOnClickListener {
                holder.itemView.context.startActivity(mvDetail)
            }
        }
    }
}