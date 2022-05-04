package com.zs.common.base.model

import com.zs.easy.common.http.retrofit.ExceptionHandle

interface IBaseModelCallback<DATA> {
    fun onLoadSuccess(modelJava: BaseModelJava<*>, data: DATA?, vararg pagingResult: PagingResult)
    fun onLoadError(
        modelJava: BaseModelJava<*>,
        responseThrowable: ExceptionHandle.ResponseThrowable?,
        msg: String?,
        vararg pagingResult: PagingResult
    )
}