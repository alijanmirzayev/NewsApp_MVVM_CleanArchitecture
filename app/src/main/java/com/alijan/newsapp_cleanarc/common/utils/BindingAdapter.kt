package com.alijan.newsapp_cleanarc.common.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter

@BindingAdapter("setImageURL")
fun setImageURL(imageView: ImageView, url: String?) {
        imageView.setImageURL(url)
}