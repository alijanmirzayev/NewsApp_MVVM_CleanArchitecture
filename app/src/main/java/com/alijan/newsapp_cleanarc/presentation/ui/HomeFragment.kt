package com.alijan.newsapp_cleanarc.presentation.ui

import android.util.Log
import androidx.fragment.app.viewModels
import com.alijan.newsapp_cleanarc.common.base.BaseFragment
import com.alijan.newsapp_cleanarc.common.base.NetworkResponse
import com.alijan.newsapp_cleanarc.data.model.HeadlineCategory
import com.alijan.newsapp_cleanarc.data.model.HeadlineCountry
import com.alijan.newsapp_cleanarc.databinding.FragmentHomeBinding
import com.alijan.newsapp_cleanarc.presentation.adapter.HeadlineCategoryAdapter
import com.alijan.newsapp_cleanarc.presentation.adapter.HeadlineCountryAdapter
import com.alijan.newsapp_cleanarc.presentation.adapter.NewsAdapter
import com.alijan.newsapp_cleanarc.presentation.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>() {
    private val viewModel by viewModels<HomeViewModel>()
    private val adapterHeadlineCategory = HeadlineCategoryAdapter()
    private val adapterHeadlineCountry = HeadlineCountryAdapter()
    private val adapterNews = NewsAdapter()
    private var categoryName = "Business"
    private var countryName = "us"

    override fun layoutInflater(): FragmentHomeBinding {
        return FragmentHomeBinding.inflate(layoutInflater)
    }

    override fun setupUI() {
        setupRecycleAdapter()
    }

    private fun setupRecycleAdapter() {
        binding.apply {
            rvHeaderCategory.adapter = adapterHeadlineCategory
            rvHeaderCountry.adapter = adapterHeadlineCountry
            rvNews.adapter = adapterNews
        }

        val newListHeadlineCategory = arrayListOf<HeadlineCategory>(
            HeadlineCategory("Business", true),
            HeadlineCategory("Entertainment", false),
            HeadlineCategory("General", false),
            HeadlineCategory("Health", false),
            HeadlineCategory("Science", false),
            HeadlineCategory("Sports", false),
            HeadlineCategory("Technology", false)
        )

        adapterHeadlineCategory.updateList(newListHeadlineCategory)
        adapterHeadlineCategory.onClick = {
            categoryName = it
            viewModel.getNewsByTopHeadline(countryName, it.lowercase())
        }

        val newListHeadlineCountry = arrayListOf<HeadlineCountry>(
            HeadlineCountry("United States", "us", true),
            HeadlineCountry("Germany", "de", false),
            HeadlineCountry("Russia", "ru", false),
            HeadlineCountry("Turkey", "tr", false),
        )

        adapterHeadlineCountry.updateList(newListHeadlineCountry)
        adapterHeadlineCountry.onClick = {
            countryName = it
            viewModel.getNewsByTopHeadline(it, categoryName)
        }
    }

    override fun observerViewModel() {
        viewModel.newsList.observe(viewLifecycleOwner) {
            when (it) {
                is NetworkResponse.Error -> Log.e("salam2", it.message.toString())
                is NetworkResponse.Loading -> Log.e("salam2", "loading")
                is NetworkResponse.Success -> it.data?.let { it1 -> adapterNews.updateList(it1.articles) }
            }
        }
    }

}