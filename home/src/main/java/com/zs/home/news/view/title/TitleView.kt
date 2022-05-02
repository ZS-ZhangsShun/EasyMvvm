package com.zs.home.news.view.title

import android.content.Context
import com.zs.common.base.view.BaseCustomView
import com.zs.easy.common.utils.LogUtil
import com.zs.easy.common.utils.ToastUtil
import com.zs.home.R
import com.zs.home.databinding.TitleViewBinding

class TitleView(context: Context) : BaseCustomView<TitleViewBinding, TitleViewModel>(context){

    override fun onRootViewClicked() {
        LogUtil.i("click url is ${viewModel.jumpUrl}")
        ToastUtil.showShortToast("click url is ${viewModel.jumpUrl}")
    }

    override fun getLayoutId(): Int {
        return R.layout.title_view
    }

    override fun bindViewModel(viewModel: TitleViewModel) {
        binding.viewModel = viewModel
    }
}