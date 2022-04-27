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
import com.zs.easy.common.http.retrofit.CommonRetrofitServiceFactory
import com.zs.easy.common.http.retrofit.EasySubscriber
import com.zs.easy.common.http.retrofit.ExceptionHandle
import com.zs.easy.common.utils.LogUtil
import com.zs.home.databinding.FragmentNewsBinding
import com.zs.home.network.api.NewsApi
import com.zs.home.network.dto.news.NewsListDTO
import com.zs.home.network.dto.news.NewsListDTO.Contentlist
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by Allen on 2017/7/20.
 * 保留所有版权，未经允许请不要分享到互联网和其他人
 */
class NewsListFragment : Fragment() {
    private var contentlist: MutableList<Contentlist> = mutableListOf()
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
        mAdapter = NewsListRecyclerViewAdapter(requireContext())
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
                        contentlist.clear()
                    }
                    if (t.showapi_res_body == null || t.showapi_res_body.pagebean == null || t.showapi_res_body.pagebean.contentlist == null) {
                        return
                    }
                    contentlist.addAll(t.showapi_res_body.pagebean.contentlist)
                    mAdapter!!.setData(contentlist)
                    mPage++
                    viewDataBinding!!.refreshLayout.finishRefresh()
                    viewDataBinding!!.refreshLayout.finishLoadMore()
                }

            })
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