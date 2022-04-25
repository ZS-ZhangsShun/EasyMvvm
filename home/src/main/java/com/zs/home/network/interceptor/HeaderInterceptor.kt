package com.zs.home.network.interceptor

import com.zs.home.network.util.TecentUtil
import okhttp3.Interceptor
import okhttp3.Response

class HeaderInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val timeStr: String = TecentUtil.getTimeStr()
        val builder = chain.request().newBuilder()
        builder.addHeader("Source", "source")
        builder.addHeader("Authorization", TecentUtil.getAuthorization(timeStr))
        builder.addHeader("Date", timeStr)
        return chain.proceed(builder.build())
    }
}