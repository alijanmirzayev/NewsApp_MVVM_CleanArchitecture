package com.alijan.newsapp_cleanarc.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alijan.newsapp_cleanarc.data.model.HeadlineCategory
import com.alijan.newsapp_cleanarc.databinding.ItemHeadlineCategoryBinding

class HeadlineCategoryAdapter :
    RecyclerView.Adapter<HeadlineCategoryAdapter.HeadlineCategoryViewHolder>() {

    private val list = arrayListOf<HeadlineCategory>()
    lateinit var onClick: (category: String) -> Unit

    inner class HeadlineCategoryViewHolder(val itemHeadlineCategoryBinding: ItemHeadlineCategoryBinding) :
        RecyclerView.ViewHolder(itemHeadlineCategoryBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeadlineCategoryViewHolder {
        val view =
            ItemHeadlineCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HeadlineCategoryViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: HeadlineCategoryViewHolder, position: Int) {
        val currentItem = list[position]
        holder.itemHeadlineCategoryBinding.item = currentItem
        holder.itemHeadlineCategoryBinding.buttonHeadlineCategory.setOnClickListener {
            list.mapIndexed { index, it ->
                if (it.categoryName == currentItem.categoryName) {
                    it.isSelected = true
                    notifyItemChanged(position)
                    return@mapIndexed it
                }
                if (it.isSelected) {
                    it.isSelected = false
                    notifyItemChanged(index)
                    return@mapIndexed it
                } else return@mapIndexed it
            }
            onClick(currentItem.categoryName)
        }
    }

    fun updateList(newList: List<HeadlineCategory>){
        list.clear()
        list.addAll(newList)
        notifyDataSetChanged()
    }

}