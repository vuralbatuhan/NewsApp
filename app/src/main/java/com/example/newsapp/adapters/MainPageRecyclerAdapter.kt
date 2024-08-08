package com.example.newsapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newsapp.data.Article
import com.example.newsapp.databinding.NewsItemRowBinding
import com.example.newsapp.fragments.MainNewsFragmentDirections

class MainPageRecyclerAdapter (private val article: MutableList<Article?>?) :
    RecyclerView.Adapter<MainPageRecyclerAdapter.ArticleViewHolder>() {

    inner class ArticleViewHolder(private val binding: NewsItemRowBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(article: Article) {
            binding.articleTitle.text = article.title
            binding.articleDescription.text = article.description.toString()
            binding.articleDateTime.text = article.publishedAt
            binding.articleSource.text = article.source?.name
            Glide.with(binding.articleImage).load(article.urlToImage).into(binding.articleImage)


        }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
            val binding =
                NewsItemRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return ArticleViewHolder(binding)
        }

        override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
            holder.bind(article!![position]!!)
            holder.itemView.setOnClickListener {
                val action = MainNewsFragmentDirections.actionMainNewsFragmentToDetailNewsFragment(article!![position]!!)
                it.findNavController().navigate(action)
            }

        }

        override fun getItemCount(): Int = article!!.size

        fun updateData(newArticle: List<Article?>?) {
            article?.clear()
            article?.addAll(newArticle!!)
            notifyDataSetChanged()
        }



}