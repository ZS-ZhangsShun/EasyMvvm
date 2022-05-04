package com.zs.home.news.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.alibaba.fastjson.JSON
import com.google.android.material.tabs.TabLayout
import com.zs.common.base.model.BaseModelJava
import com.zs.common.base.model.IBaseModelCallback
import com.zs.common.base.model.PagingResult
import com.zs.common.debug.DebugUtil
import com.zs.easy.common.http.retrofit.CommonRetrofitServiceFactory
import com.zs.easy.common.http.retrofit.EasySubscriber
import com.zs.easy.common.http.retrofit.ExceptionHandle
import com.zs.easy.common.utils.LogUtil
import com.zs.home.R
import com.zs.home.databinding.FragmentHomeBinding
import com.zs.home.network.api.NewsApi
import com.zs.home.network.dto.news.NewsChannelsDTO
import com.zs.home.network.dto.news.NewsListDTO
import com.zs.home.network.model.NewsChannelsModel
import com.zs.home.network.model.NewsListModel
import com.zs.home.news.adapter.NewsFragmentAdapter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class NewsFragment : Fragment(), IBaseModelCallback<MutableList<NewsChannelsDTO.ChannelList>> {
    var binding: FragmentHomeBinding? = null
    private var adapter: NewsFragmentAdapter? = null
    private var model: NewsChannelsModel? = null
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
        model = NewsChannelsModel()
        model!!.registerCallback(this)
        model!!.load()
        return binding!!.root
    }

    override fun onLoadSuccess(
        model: BaseModelJava<*>,
        data: MutableList<NewsChannelsDTO.ChannelList>?,
        vararg pagingResult: PagingResult
    ) {
        if (model is NewsChannelsModel) {
            LogUtil.i("cur model is NewsChannelsModel")
        }
        LogUtil.i("getNewsChannels success totalNum = ${data?.size}")
        adapter!!.setChannels(data)
    }

    override fun onLoadError(
        model: BaseModelJava<*>,
        responseThrowable: ExceptionHandle.ResponseThrowable?,
        msg: String?,
        vararg pagingResult: PagingResult
    ) {
        LogUtil.i("getNewsChannels error code = ${responseThrowable!!.code}")
        LogUtil.i("getNewsChannels error = ${responseThrowable.errorJson}")
    }
}