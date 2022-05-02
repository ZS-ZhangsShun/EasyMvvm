package com.zs.home.network.model

import com.alibaba.fastjson.JSON
import com.zs.common.base.model.IBaseModelCallback
import com.zs.common.debug.DebugUtil
import com.zs.easy.common.http.retrofit.CommonRetrofitServiceFactory
import com.zs.easy.common.http.retrofit.EasySubscriber
import com.zs.easy.common.http.retrofit.ExceptionHandle
import com.zs.home.network.api.NewsApi
import com.zs.home.network.dto.news.NewsChannelsDTO
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class NewsChannelsModel(val callback: IBaseModelCallback<MutableList<NewsChannelsDTO.ChannelList>>) {
    fun loadChannels() {
        if (DebugUtil.isDebug) {
            val dto: NewsChannelsDTO = JSON.parseObject(
                DebugUtil.channelsJson, NewsChannelsDTO::class.java
            )
            callback.onLoadSuccess(dto.showapi_res_body.channelList)
            return
        }
        CommonRetrofitServiceFactory.getInstance().createService(NewsApi::class.java)
            .getNewsChannels()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : EasySubscriber<NewsChannelsDTO>() {
                override fun onError(responseThrowable: ExceptionHandle.ResponseThrowable?) {
                    callback.onLoadError(responseThrowable, responseThrowable?.message)
                }

                override fun onComplete(t: NewsChannelsDTO?) {
                    callback.onLoadSuccess(t?.showapi_res_body!!.channelList)
                }

            })

    }

}