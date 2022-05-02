package com.zs.home.news.fragment

import com.zs.home.news.adapter.NewsListRecyclerViewAdapter
import android.view.LayoutInflater
import android.view.ViewGroup
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.zs.home.R
import androidx.recyclerview.widget.LinearLayoutManager
import com.alibaba.fastjson.JSON
import com.zs.easy.common.http.retrofit.CommonRetrofitServiceFactory
import com.zs.easy.common.http.retrofit.EasySubscriber
import com.zs.easy.common.http.retrofit.ExceptionHandle
import com.zs.easy.common.utils.LogUtil
import com.zs.home.databinding.FragmentNewsBinding
import com.zs.home.network.api.NewsApi
import com.zs.home.network.dto.news.NewsListDTO
import com.zs.common.base.viewmodel.BaseViewModel
import com.zs.common.debug.DebugUtil
import com.zs.home.news.view.title.TitleViewModel
import com.zs.home.news.view.titlewithpicture.TitlePictureViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class NewsListFragment : Fragment() {
    private var viewModels: MutableList<BaseViewModel> = mutableListOf()
    private var mAdapter: NewsListRecyclerViewAdapter? = null
    private var viewDataBinding: FragmentNewsBinding? = null
    private var mPage = 1
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewDataBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_news, container, false)
        mAdapter = NewsListRecyclerViewAdapter()
        viewDataBinding!!.listview.setHasFixedSize(true)
        viewDataBinding!!.listview.layoutManager = LinearLayoutManager(context)
        viewDataBinding!!.listview.adapter = mAdapter
        load()
        viewDataBinding!!.refreshLayout.setOnRefreshListener {
            mPage = 0
            load()
        }
        viewDataBinding!!.refreshLayout.setOnLoadMoreListener { load() }
        return viewDataBinding!!.root
    }

    private fun load() {
        if (DebugUtil.isDebug) {
            val result = DebugUtil.getNewsList(arguments?.getString(BUNDLE_KEY_PARAM_CHANNEL_ID))
            if (!result.isEmpty()) {
                val dto: NewsListDTO = JSON.parseObject(result, NewsListDTO::class.java)
                refreshWithNewsListDTO(dto)
                return
            }

        }
        CommonRetrofitServiceFactory.getInstance().createService(NewsApi::class.java)
            .getNewsContents(
                arguments?.getString(BUNDLE_KEY_PARAM_CHANNEL_ID), arguments?.getString(
                    BUNDLE_KEY_PARAM_CHANNEL_NAME
                ), mPage.toString()
            )
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : EasySubscriber<NewsListDTO>() {
                override fun onError(responseThrowable: ExceptionHandle.ResponseThrowable?) {
                    LogUtil.i("getNewsContents error code = ${responseThrowable!!.code}")
                    LogUtil.i("getNewsContents error = ${responseThrowable.errorJson}")
                }

                override fun onComplete(t: NewsListDTO?) {
                    LogUtil.i("getNewsContents cur news size  = ${t!!.showapi_res_body?.pagebean?.contentlist?.size}")
                    if (mPage == 0) {
                        viewModels.clear()
                    }
                    if (t.showapi_res_body == null || t.showapi_res_body.pagebean == null || t.showapi_res_body.pagebean.contentlist == null) {
                        return
                    }
                    refreshWithNewsListDTO(t)
                }

            })
    }

    private fun refreshWithNewsListDTO(t: NewsListDTO) {
        //将请求到的数据装换为 viewModel
        t.showapi_res_body.pagebean.contentlist.forEach {
            if (it.imageurls != null && it.imageurls.size > 0) {
                val titlePicViewModel = TitlePictureViewModel()
                titlePicViewModel.jumpUrl = it.link
                titlePicViewModel.name = it.title
                titlePicViewModel.picUrl = it.imageurls[0].url
                viewModels.add(titlePicViewModel)
            } else {
                val titleViewModel = TitleViewModel()
                titleViewModel.jumpUrl = it.link
                titleViewModel.name = it.title
                viewModels.add(titleViewModel)
            }
        }

        mAdapter!!.setData(viewModels)
        mPage++
        viewDataBinding!!.refreshLayout.finishRefresh()
        viewDataBinding!!.refreshLayout.finishLoadMore()
    }

    companion object {
        protected const val BUNDLE_KEY_PARAM_CHANNEL_ID = "bundle_key_param_channel_id"
        protected const val BUNDLE_KEY_PARAM_CHANNEL_NAME = "bundle_key_param_channel_name"

        @JvmStatic
        fun newInstance(channelId: String?, channelName: String?): NewsListFragment {
            val fragment = NewsListFragment()
            val bundle = Bundle()
            bundle.putString(BUNDLE_KEY_PARAM_CHANNEL_ID, channelId)
            bundle.putString(BUNDLE_KEY_PARAM_CHANNEL_NAME, channelName)
            fragment.arguments = bundle
            return fragment
        }
    }
}