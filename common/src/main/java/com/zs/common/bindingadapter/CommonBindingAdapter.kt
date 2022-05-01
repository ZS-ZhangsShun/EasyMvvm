package com.zs.common.bindingadapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

class CommonBindingAdapter {
    companion object {
        @JvmStatic
        @BindingAdapter("loadImageUrl")
        fun loadImageUrl(imageView: ImageView, picUrl: String) {
            Glide.with(imageView.context).load(picUrl).into(imageView)
        }
    }
}