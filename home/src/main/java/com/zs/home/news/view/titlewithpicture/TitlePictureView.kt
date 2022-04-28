package com.zs.home.news.view.titlewithpicture

import android.content.Context
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import com.zs.easy.common.utils.LogUtil
import com.zs.easy.common.utils.ToastUtil
import com.zs.home.R
import com.zs.home.databinding.PictureTitleViewBinding

class TitlePictureView(context: Context) : LinearLayout(context) {
    var binding: PictureTitleViewBinding? = null
    var titleViewModel: PictureTitleViewModel? = null

    init {
        binding = DataBindingUtil.inflate(
            LayoutInflater.from(context),
            R.layout.picture_title_view,
            this,
            false
        )
        binding!!.root.setOnClickListener {
            LogUtil.i("click web url is ${titleViewModel!!.jumpUrl}")
            LogUtil.i("click pic url is ${titleViewModel!!.picUrl}")
            ToastUtil.showShortToast("click url is ${titleViewModel!!.jumpUrl}")
        }
        addView(binding!!.root)
    }

    fun setData(titleViewModel: PictureTitleViewModel) {
        binding!!.viewModel = titleViewModel
        binding!!.executePendingBindings()
        this.titleViewModel = titleViewModel
    }
}