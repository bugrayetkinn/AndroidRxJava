package com.yetkin.androidrxjava.util

import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("imageUrl")
fun AppCompatImageView.loadImage(imageUrl: String) {
    Glide.with(this).load(imageUrl).into(this)
}