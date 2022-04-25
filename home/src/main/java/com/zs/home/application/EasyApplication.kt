package com.zs.home.application

import android.app.Application
import com.zs.easy.common.EasyCommon
import com.zs.easy.common.http.retrofit.CommonRetrofitServiceFactory
import com.zs.home.constants.EasyConstants
import com.zs.home.network.interceptor.HeaderInterceptor

class EasyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        EasyCommon.init(this,"easy_mvvm",true)
        initHttp()
    }

    private fun initHttp() {
        CommonRetrofitServiceFactory.init(EasyConstants.BASE_URL)
        CommonRetrofitServiceFactory.addInterceptor(HeaderInterceptor())
    }
}