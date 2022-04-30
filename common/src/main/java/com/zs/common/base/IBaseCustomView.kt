package com.zs.common.base

interface IBaseCustomView<DATA : BaseViewModel> {
    fun setData(viewModel: DATA)
}