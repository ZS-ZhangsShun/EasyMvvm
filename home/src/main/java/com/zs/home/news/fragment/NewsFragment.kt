package com.zs.home.news.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayout
import com.zs.easy.common.http.retrofit.CommonRetrofitServiceFactory
import com.zs.easy.common.http.retrofit.EasySubscriber
import com.zs.easy.common.http.retrofit.ExceptionHandle
import com.zs.easy.common.utils.LogUtil
import com.zs.home.R
import com.zs.home.databinding.FragmentHomeBinding
import com.zs.home.network.api.NewsApi
import com.zs.home.network.dto.news.NewsChannelsDTO
import com.zs.home.network.dto.news.NewsListDTO
import com.zs.home.news.adapter.NewsFragmentAdapter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class NewsFragment : Fragment() {
    var binding: FragmentHomeBinding? = null
    var adapter : NewsFragmentAdapter? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        adapter = NewsFragmentAdapter(childFragmentManager)
        binding!!.viewpager.adapter = adapter
        binding!!.viewpager.offscreenPageLimit = 1
        binding!!.tablayout.tabMode = TabLayout.MODE_SCROLLABLE
        binding!!.tablayout.setupWithViewPager(binding!!.viewpager)
        loadChannels()
        return binding!!.root
    }

    private fun loadChannels() {
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
                    LogUtil.i("getNewsChannels totalNum = ${t!!.showapi_res_body?.totalNum}")
                    //数据转换
                    val channelList = t.showapi_res_body?.channelList
                    val list : ArrayList<NewsFragmentAdapter.Channel> = ArrayList()
                    channelList?.forEach {
                        val channel:NewsFragmentAdapter.Channel = NewsFragmentAdapter.Channel()
                        channel.channelId = it.channelId
                        channel.channelName = it.name
                        list.add(channel)
                    }
                    adapter!!.setChannels(list)
                }

            })

    }
}