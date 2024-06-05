package com.alijan.newsapp_cleanarc.common.utils

import android.widget.ImageView
import com.alijan.newsapp_cleanarc.R
import com.bumptech.glide.Glide

fun ImageView.setImageURL(url: String?){
    Glide
        .with(this)
        .load(url)
        .fitCenter()
        .placeholder(R.drawable.no_news)
        .into(this);
}