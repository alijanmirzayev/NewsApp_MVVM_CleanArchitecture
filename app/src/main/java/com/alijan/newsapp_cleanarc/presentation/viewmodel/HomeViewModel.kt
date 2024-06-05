package com.alijan.newsapp_cleanarc.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alijan.newsapp_cleanarc.common.base.NetworkResponse
import com.alijan.newsapp_cleanarc.data.model.ArticlesResponse
import com.alijan.newsapp_cleanarc.domain.usecase.GetNewsByHeadline
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val getNewsByHeadline: GetNewsByHeadline) :
    ViewModel() {

    private val _newsList: MutableLiveData<NetworkResponse<ArticlesResponse>> = MutableLiveData()
    val newsList: LiveData<NetworkResponse<ArticlesResponse>> get() = _newsList

    init {
        getNewsByTopHeadline("us","business")
    }

    fun getNewsByTopHeadline(country: String, category: String) {
        _newsList.value = NetworkResponse.Loading()
        viewModelScope.launch {
            try {
                val result = getNewsByHeadline.execute(country, category)
                _newsList.value = result
            } catch (e: Exception) {
                _newsList.value = NetworkResponse.Error(e.localizedMessage.toString())
            }
        }
    }

}