package com.zs.home.news.view.titlewithpicture

import android.content.Context
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.zs.easy.common.utils.LogUtil
import com.zs.easy.common.utils.ToastUtil
import com.zs.home.R
import com.zs.home.databinding.TitlePictureViewBinding

class TitlePictureView(context: Context) : LinearLayout(context) {
    var binding: TitlePictureViewBinding? = null
    var viewModel: TitlePictureViewModel? = null

    init {
        binding = DataBindingUtil.inflate(
            LayoutInflater.from(context),
            R.layout.title_picture_view,
            this,
            false
        )
        binding!!.root.setOnClickListener {
            LogUtil.i("click web url is ${viewModel!!.jumpUrl}")
            LogUtil.i("click pic url is ${viewModel!!.picUrl}")
            ToastUtil.showShortToast("click url is ${viewModel!!.jumpUrl}")
        }
        addView(binding!!.root)
    }

    fun setData(titleViewModel: TitlePictureViewModel) {
        binding!!.viewModel = titleViewModel
        binding!!.executePendingBindings()
        this.viewModel = titleViewModel
    }

    companion object {
        @JvmStatic
        @BindingAdapter("loadImageUrl")
        fun loadImageUrl(imageView: ImageView, picUrl: String) {
            Glide.with(imageView.context).load(picUrl).into(imageView)
        }
    }


}