package com.binar.latihanmvvmwithapiorg.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.binar.latihanmvvmwithapiorg.databinding.ItemArticleBinding
import com.binar.latihanmvvmwithapiorg.model.article.Article
import com.bumptech.glide.Glide

class ArticleAdapter(var listArticle : List<Article>): RecyclerView.Adapter<ArticleAdapter.ViewHolder>() {

    var onClickArt : ((Article)->Unit)? = null

    class ViewHolder( var binding : ItemArticleBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleAdapter.ViewHolder {
        val view = ItemArticleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ArticleAdapter.ViewHolder, position: Int) {
        holder.binding.titleArticle.text = listArticle[position].title
        holder.binding.DateArticle.text = listArticle[position].publishedAt
        Glide.with(holder.itemView).load(listArticle[position].urlToImage).into(holder.binding.imageArticle)

        holder.binding.itemArticle.setOnClickListener {
            onClickArt?.invoke(listArticle[position])
        }
    }

    override fun getItemCount(): Int {
        return listArticle.size
    }
    fun setDataArticle(list : List<Article>){
        listArticle = list
        notifyDataSetChanged()
    }
}