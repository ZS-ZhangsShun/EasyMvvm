package com.zs.common.base

interface BaseCustomView<DATA : BaseViewModel> {
    fun setData(viewModel: DATA)
}