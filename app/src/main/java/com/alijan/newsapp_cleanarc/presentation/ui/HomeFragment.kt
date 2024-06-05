package com.alijan.newsapp_cleanarc.presentation.ui

import android.util.Log
import androidx.fragment.app.viewModels
import com.alijan.newsapp_cleanarc.common.base.BaseFragment
import com.alijan.newsapp_cleanarc.common.base.NetworkResponse
import com.alijan.newsapp_cleanarc.databinding.FragmentHomeBinding
import com.alijan.newsapp_cleanarc.presentation.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>() {
    private val viewModel by viewModels<HomeViewModel>()
    override fun layoutInflater(): FragmentHomeBinding {
        return FragmentHomeBinding.inflate(layoutInflater)
    }

    override fun setupUI() {

    }

    override fun observerViewModel() {
        viewModel.newsList.observe(viewLifecycleOwner) {
            when (it) {
                is NetworkResponse.Error -> Log.e("salam2", it.message.toString())
                is NetworkResponse.Loading -> Log.e("salam2", "loading")
                is NetworkResponse.Success -> Log.e("salam2", it.data.toString())
            }
        }
    }

}