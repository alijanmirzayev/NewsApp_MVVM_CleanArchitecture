package com.alijan.newsapp_cleanarc.presentation.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alijan.newsapp_cleanarc.data.model.HeadlineCountry
import com.alijan.newsapp_cleanarc.databinding.ItemHeadlineCountryBinding

class HeadlineCountryAdapter :
    RecyclerView.Adapter<HeadlineCountryAdapter.HeadlineCountryViewHolder>() {

    private val list = arrayListOf<HeadlineCountry>()
    lateinit var onClick: (prefix: String) -> Unit

    inner class HeadlineCountryViewHolder(val itemHeadlineCountryBinding: ItemHeadlineCountryBinding) :
        RecyclerView.ViewHolder(itemHeadlineCountryBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeadlineCountryViewHolder {
        val view =
            ItemHeadlineCountryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HeadlineCountryViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: HeadlineCountryViewHolder, position: Int) {
        val currentItem = list[position]
        holder.itemHeadlineCountryBinding.item = currentItem

        holder.itemHeadlineCountryBinding.buttonHeadlineCategory.setOnClickListener {
            list.mapIndexed { index, it ->
                if (it.prefix == currentItem.prefix) {
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
            onClick(currentItem.prefix)
        }
    }

    fun updateList(newList: List<HeadlineCountry>) {
        list.clear()
        list.addAll(newList)
        notifyDataSetChanged()
    }

}