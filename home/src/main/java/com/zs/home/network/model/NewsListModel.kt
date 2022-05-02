package com.zs.home.network.model

import com.alibaba.fastjson.JSON
import com.zs.common.base.model.IBaseModelCallback
import com.zs.common.base.viewmodel.BaseViewModel
import com.zs.common.debug.DebugUtil
import com.zs.easy.common.http.retrofit.CommonRetrofitServiceFactory
import com.zs.easy.common.http.retrofit.EasySubscriber
import com.zs.easy.common.http.retrofit.ExceptionHandle
import com.zs.home.network.api.NewsApi
import com.zs.home.network.dto.news.NewsListDTO
import com.zs.home.news.view.title.TitleViewModel
import com.zs.home.news.view.titlewithpicture.TitlePictureViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class NewsListModel(val callback: IBaseModelCallback<MutableList<BaseViewModel>>) {
    fun loadChannels(id: String?, name: String?, page: String) {
        if (DebugUtil.isDebug) {
            val result = DebugUtil.getNewsList(id)
            if (!result.isEmpty()) {
                val dto: NewsListDTO = JSON.parseObject(result, NewsListDTO::class.java)
                val viewModels: MutableList<BaseViewModel> =
                    convertContentListToViewModels(dto.showapi_res_body.pagebean.contentlist)
                callback.onLoadSuccess(viewModels)
                return
            }

        }
        CommonRetrofitServiceFactory.getInstance().createService(NewsApi::class.java)
            .getNewsContents(id, name, page)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : EasySubscriber<NewsListDTO>() {
                override fun onError(responseThrowable: ExceptionHandle.ResponseThrowable?) {
                    callback.onLoadError(responseThrowable, responseThrowable?.message)
                }

                override fun onComplete(t: NewsListDTO?) {
                    if (t!!.showapi_res_body == null || t.showapi_res_body.pagebean == null || t.showapi_res_body.pagebean.contentlist == null) {
                        return
                    }
                    val viewModels: MutableList<BaseViewModel> =
                        convertContentListToViewModels(t.showapi_res_body.pagebean.contentlist)
                    callback.onLoadSuccess(viewModels)
                }

            })
    }

    private fun convertContentListToViewModels(list: List<NewsListDTO.Contentlist>): MutableList<BaseViewModel> {
        val viewModels: MutableList<BaseViewModel> = mutableListOf()
        list.forEach {
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
        return viewModels
    }
}