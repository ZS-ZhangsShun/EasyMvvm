package com.zs.home.news.view.titlewithpicture

import android.content.Context
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.zs.common.base.BaseCustomView
import com.zs.easy.common.utils.LogUtil
import com.zs.easy.common.utils.ToastUtil
import com.zs.home.R
import com.zs.home.databinding.TitlePictureViewBinding

class TitlePictureView(context: Context) :
    BaseCustomView<TitlePictureViewBinding, TitlePictureViewModel>(context) {

    override fun onRootViewClicked() {
        LogUtil.i("click web url is ${viewModel.jumpUrl}")
        LogUtil.i("click pic url is ${viewModel.picUrl}")
        ToastUtil.showShortToast("click url is ${viewModel.jumpUrl}")
    }

    override fun getLayoutId(): Int {
        return R.layout.title_picture_view
    }

    override fun bindViewModel(viewModel: TitlePictureViewModel) {
        binding.viewModel = viewModel
    }

}