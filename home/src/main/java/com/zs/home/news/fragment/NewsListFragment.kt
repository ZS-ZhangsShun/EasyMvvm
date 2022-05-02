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
import com.zs.common.base.model.IBaseModelCallback
import com.zs.easy.common.http.retrofit.ExceptionHandle
import com.zs.easy.common.utils.LogUtil
import com.zs.home.databinding.FragmentNewsBinding
import com.zs.common.base.viewmodel.BaseViewModel
import com.zs.home.network.model.NewsListModel

class NewsListFragment : Fragment(), IBaseModelCallback<MutableList<BaseViewModel>> {
    private var viewModels: MutableList<BaseViewModel> = mutableListOf()
    private var mAdapter: NewsListRecyclerViewAdapter? = null
    private var viewDataBinding: FragmentNewsBinding? = null
    private var mPage = 0
    private var model: NewsListModel? = null
    private var channelId: String? = null
    private var channelName: String? = null
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
        channelId = arguments?.getString(BUNDLE_KEY_PARAM_CHANNEL_ID)
        channelName = arguments?.getString(BUNDLE_KEY_PARAM_CHANNEL_NAME)
        model = NewsListModel(this)
        model!!.loadChannels(channelId, channelName, mPage.toString())
        viewDataBinding!!.refreshLayout.setOnRefreshListener {
            mPage = 0
            model!!.loadChannels(channelId, channelName, mPage.toString())
        }
        viewDataBinding!!.refreshLayout.setOnLoadMoreListener {
            mPage++
            model!!.loadChannels(channelId, channelName, mPage.toString())
        }
        return viewDataBinding!!.root
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

    override fun onLoadSuccess(data: MutableList<BaseViewModel>?) {
        LogUtil.i("getNewsContents cur news size  = ${data?.size}")
        if (mPage == 0) {
            viewModels.clear()
        }
        if (data == null || data.size == 0) {
            return
        }
        viewModels.addAll(data)
        mAdapter!!.setData(viewModels)
        viewDataBinding!!.refreshLayout.finishRefresh()
        viewDataBinding!!.refreshLayout.finishLoadMore()
    }

    override fun onLoadError(responseThrowable: ExceptionHandle.ResponseThrowable?, msg: String?) {
        LogUtil.i("getNewsContents error code = ${responseThrowable?.code}")
        LogUtil.i("getNewsContents error = ${responseThrowable?.errorJson}")
    }
}