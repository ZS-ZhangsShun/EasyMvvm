package com.zs.home.activity

import android.Manifest
import androidx.appcompat.app.AppCompatActivity
import com.zs.home.mine.fragment.MineFragment
import android.os.Bundle
import androidx.core.app.ActivityCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.zs.easy.common.http.retrofit.CommonRetrofitServiceFactory
import com.zs.easy.common.http.retrofit.EasySubscriber
import com.zs.easy.common.http.retrofit.ExceptionHandle
import com.zs.easy.common.utils.LogUtil
import com.zs.home.R
import com.zs.home.databinding.ActivityMainBinding
import com.zs.home.network.api.NewsApi
import com.zs.home.network.dto.news.NewsChannelsDTO
import com.zs.home.network.dto.news.NewsListDTO
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {
    private val mHomeFragment: Fragment = MineFragment()
    private val mAccountFragment = MineFragment()
    var binding: ActivityMainBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        ActivityCompat.requestPermissions(
            this,
            arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
            0
        )

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
                    LogUtil.i("getNewsChannels totalNum = ${t!!.showapi_res_body.totalNum}")

                    val channel = t.showapi_res_body.channelList[0]
                    CommonRetrofitServiceFactory.getInstance().createService(NewsApi::class.java)
                        .getNewsContents(channel.channelId, channel.name, "1")
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(object : EasySubscriber<NewsListDTO>() {
                            override fun onError(responseThrowable: ExceptionHandle.ResponseThrowable?) {
                                LogUtil.i("getNewsContents error code = ${responseThrowable!!.code}")
                                LogUtil.i("getNewsContents error = ${responseThrowable.errorJson}")
                            }

                            override fun onComplete(t: NewsListDTO?) {
                                LogUtil.i("getNewsContents cur news size  = ${t!!.showapi_res_body.pagebean.contentlist.size}")
                            }

                        })
                }

            })

    }
}