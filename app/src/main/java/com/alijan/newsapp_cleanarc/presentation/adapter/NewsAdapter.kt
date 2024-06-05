package com.alijan.newsapp_cleanarc.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alijan.newsapp_cleanarc.data.model.Article
import com.alijan.newsapp_cleanarc.data.model.HeadlineCategory
import com.alijan.newsapp_cleanarc.databinding.ItemHeadlineCategoryBinding
import com.alijan.newsapp_cleanarc.databinding.ItemNewsBinding

class NewsAdapter :
    RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    private val list = arrayListOf<Article>()

    inner class NewsViewHolder(val itemNewsViewHolder: ItemNewsBinding) :
        RecyclerView.ViewHolder(itemNewsViewHolder.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view =
            ItemNewsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NewsViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val currentItem = list[position]
        holder.itemNewsViewHolder.item = currentItem
    }

    fun updateList(newList: List<Article>){
        list.clear()
        list.addAll(newList)
        notifyDataSetChanged()
    }

}