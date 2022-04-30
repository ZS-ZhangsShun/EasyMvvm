package com.zs.home.news.view.title

import android.content.Context
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import com.zs.easy.common.utils.LogUtil
import com.zs.easy.common.utils.ToastUtil
import com.zs.home.R
import com.zs.home.databinding.TitleViewBinding
import com.zs.common.base.IBaseCustomView

class TitleView(context: Context) : LinearLayout(context), IBaseCustomView<TitleViewModel> {
    var binding: TitleViewBinding? = null
    var viewModel: TitleViewModel? = null

    init {
        binding =
            DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.title_view, this, false)
        binding!!.root.setOnClickListener {
            LogUtil.i("click url is ${viewModel!!.jumpUrl}")
            ToastUtil.showShortToast("click url is ${viewModel!!.jumpUrl}")
        }
        addView(binding!!.root)
    }

    override fun setData(viewModel: TitleViewModel) {
        binding!!.viewModel = viewModel
        binding!!.executePendingBindings()
        this.viewModel = viewModel
    }
}