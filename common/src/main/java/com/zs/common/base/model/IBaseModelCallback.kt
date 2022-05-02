package com.zs.common.base.model

import com.zs.easy.common.http.retrofit.ExceptionHandle

interface IBaseModelCallback<DATA> {
    fun onLoadSuccess(data: DATA?, vararg pagingResult: PagingResult)
    fun onLoadError(responseThrowable: ExceptionHandle.ResponseThrowable?, msg: String?)
}