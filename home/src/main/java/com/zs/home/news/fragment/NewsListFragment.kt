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
import com.zs.common.base.model.BaseModelJava
import com.zs.common.base.model.IBaseModelCallback
import com.zs.common.base.model.PagingResult
import com.zs.easy.common.http.retrofit.ExceptionHandle
import com.zs.easy.common.utils.LogUtil
import com.zs.home.databinding.FragmentNewsBinding
import com.zs.common.base.viewmodel.BaseViewModel
import com.zs.home.network.model.NewsListModel

class NewsListFragment : Fragment(), IBaseModelCallback<MutableList<BaseViewModel>> {
    private var viewModels: MutableList<BaseViewModel> = mutableListOf()
    private var mAdapter: NewsListRecyclerViewAdapter? = null
    private var viewDataBinding: FragmentNewsBinding? = null
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
        model = NewsListModel(channelId, channelName)
        model!!.registerCallback(this)
        model!!.load()
        viewDataBinding!!.refreshLayout.setOnRefreshListener {
            model!!.load()
        }
        viewDataBinding!!.refreshLayout.setOnLoadMoreListener {
            model!!.loadNextPageData()
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

    override fun onLoadError(
        model: BaseModelJava<*>,
        responseThrowable: ExceptionHandle.ResponseThrowable?,
        msg: String?,
        vararg pagingResult: PagingResult
    ) {
        LogUtil.i("getNewsContents error code = ${responseThrowable?.code}")
        LogUtil.i("getNewsContents error = ${responseThrowable?.errorJson}")
    }

    override fun onLoadSuccess(
        model: BaseModelJava<*>,
        data: MutableList<BaseViewModel>?,
        vararg pagingResult: PagingResult
    ) {
        if (model is NewsListModel) {
            LogUtil.i("cur model is NewsListModel")
        }
        LogUtil.i("getNewsContents cur news size  = ${data?.size}")
        if (pagingResult.size > 0) {
            val pr = pagingResult[0]
            if (pr.isFristPage) {
                viewModels.clear()
            }
        }

        if (data == null || data.size == 0) {
            return
        }
        viewModels.addAll(data)
        mAdapter!!.setData(viewModels)
        viewDataBinding!!.refreshLayout.finishRefresh()
        viewDataBinding!!.refreshLayout.finishLoadMore()
    }
}