package com.example.newsapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.newsapp.databinding.FragmentDetailNewsBinding

class DetailNewsFragment : Fragment() {
    private lateinit var binding: FragmentDetailNewsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailNewsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bundle: DetailNewsFragmentArgs by navArgs()
        val news = bundle.news

        binding.textViewTitleDetail.text = news.title
        binding.textViewDescriptionDetail.text = news.description.toString()
        binding.textViewAuthorDetail.text = news.author
        binding.textViewTimeDetail.text = news.publishedAt
        Glide.with(binding.imageViewDetail).load(news.urlToImage).into(binding.imageViewDetail)
    }

}