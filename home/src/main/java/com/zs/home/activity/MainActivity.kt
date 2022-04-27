package com.zs.home.activity

import android.Manifest
import android.graphics.Color
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
import com.zs.home.databinding.ActivityMainBinding
import com.zs.home.network.api.NewsApi
import com.zs.home.network.dto.news.NewsChannelsDTO
import com.zs.home.network.dto.news.NewsListDTO
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import com.zs.common.viewpager.VpAdapter
import android.view.View
import com.zs.home.R
import com.zs.home.news.fragment.NewsFragment

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private val mNewsFragment: Fragment = NewsFragment()
    private val mAccountFragment = MineFragment()
    var binding: ActivityMainBinding? = null

    private var fragments = mutableListOf<Fragment>()
    private var vpAdapter: VpAdapter? = null

    private val HOME_NEWS_INDEX = 0
    private val HOME_MINE_INDEX = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        ActivityCompat.requestPermissions(
            this,
            arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
            0
        )

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        initView()
        initData()

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

    private fun initView() {
        binding!!.homeNewsDtv.setOnClickListener(this)
        binding!!.homeMineDtv1.setOnClickListener(this)
    }

    private fun initData() {
        fragments.add(MineFragment())
        fragments.add(MineFragment())
        vpAdapter = VpAdapter(supportFragmentManager, fragments)
        binding!!.homeVp.adapter = vpAdapter
        binding!!.homeVp.currentItem = HOME_NEWS_INDEX
    }

    override fun onClick(v: View) {
        resetTabState()
        if (v == binding!!.homeNewsDtv) {
            binding!!.homeVp.currentItem = HOME_NEWS_INDEX
            binding!!.homeNewsDtv.setTextColor(Color.parseColor("#0091FF"))
            binding!!.homeNewsDtv.setDrawableTop(R.drawable.home_news_selected)
        } else {
            binding!!.homeVp.currentItem = HOME_MINE_INDEX
            binding!!.homeMineDtv1.setTextColor(Color.parseColor("#0091FF"))
            binding!!.homeMineDtv1.setDrawableTop(R.drawable.home_mine_yes)
        }
    }

    private fun resetTabState() {
        binding!!.homeNewsDtv.setTextColor(Color.parseColor("#000000"))
        binding!!.homeNewsDtv.setDrawableTop(R.drawable.home_news_unselected)
        binding!!.homeMineDtv1.setTextColor(Color.parseColor("#000000"))
        binding!!.homeMineDtv1.setDrawableTop(R.drawable.home_mine_no)
    }
}