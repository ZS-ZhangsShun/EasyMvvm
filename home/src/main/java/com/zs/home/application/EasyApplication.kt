package com.zs.home.application

import android.app.Application
import com.zs.easy.common.EasyCommon
import com.zs.easy.common.constants.EasyConstants
import com.zs.easy.common.http.retrofit.CommonRetrofitServiceFactory
import com.zs.easy.common.utils.LogUtil
import com.zs.home.constants.EasyLocalConstants
import com.zs.home.network.interceptor.HeaderInterceptor

class EasyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        EasyCommon.init(this, "easy_mvvm", true)
        EasyConstants.TAG = "easy_mvvm"
        //日志最大10k
        LogUtil.setMaxLogLength(0.01f * 1024 * 1024)
        initHttp()
    }

    private fun initHttp() {
        CommonRetrofitServiceFactory.init(EasyLocalConstants.BASE_URL)
        CommonRetrofitServiceFactory.addInterceptor(HeaderInterceptor())
    }
}