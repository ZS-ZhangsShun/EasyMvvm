package com.zs.home.news.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.zs.easy.common.http.retrofit.CommonRetrofitServiceFactory
import com.zs.easy.common.http.retrofit.EasySubscriber
import com.zs.easy.common.http.retrofit.ExceptionHandle
import com.zs.easy.common.utils.LogUtil
import com.zs.home.R
import com.zs.home.network.api.NewsApi
import com.zs.home.network.dto.news.NewsChannelsDTO
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        CommonRetrofitServiceFactory.getInstance().createService(NewsApi::class.java)
            .getNewsChannels()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : EasySubscriber<NewsChannelsDTO>() {
                override fun onError(responseThrowable: ExceptionHandle.ResponseThrowable?) {
                    LogUtil.i("getNewsChannels error code = ${responseThrowable!!.code}")
                    LogUtil.i("getNewsChannels error = ${responseThrowable.errorJson}")
                }

                override fun onComplete(t: NewsChannelsDTO?) {
                    LogUtil.i("totalNum = ${t!!.showapiResBody.totalNum}")
                }

            })
    }
}