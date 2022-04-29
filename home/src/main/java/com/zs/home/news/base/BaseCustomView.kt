package com.zs.home.news.base

interface BaseCustomView<DATA : BaseViewModel> {
    fun setData(viewModel: DATA)
}