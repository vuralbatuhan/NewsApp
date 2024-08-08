package com.example.newsapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsapp.adapters.MainPageRecyclerAdapter
import com.example.newsapp.data.NewsResponse
import com.example.newsapp.databinding.FragmentMainNewsBinding
import com.example.newsapp.viewmodels.MainNewsViewModel

class MainNewsFragment : Fragment() {
    private lateinit var binding: FragmentMainNewsBinding
    private val mainNewsViewModel: MainNewsViewModel by viewModels()
    private lateinit var mainList: NewsResponse
    private var newsAdapter = MainPageRecyclerAdapter(arrayListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainNewsBinding.inflate(layoutInflater, container, false)
        return  binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainNewsViewModel.getAllMainNews("araba","a106dbc1b6634bf68b0e1dd0a263ee40")
        mainNewsViewModel.mainNewsList.observe(viewLifecycleOwner) {
            response -> mainList = response
            newsAdapter.updateData(mainList.articles)
            binding.recyclerViewMainPage.layoutManager = LinearLayoutManager(requireActivity())
            binding.recyclerViewMainPage.adapter = newsAdapter
        }
    }
}
