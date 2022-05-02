package com.zs.common.base.view

import com.zs.common.base.viewmodel.BaseViewModel

interface IBaseCustomView<DATA : BaseViewModel> {
    fun setData(viewModel: DATA)
}