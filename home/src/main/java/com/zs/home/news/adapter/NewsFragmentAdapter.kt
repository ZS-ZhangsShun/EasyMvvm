package com.zs.home.news.adapter

import androidx.fragment.app.FragmentPagerAdapter
import android.os.Parcelable
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.zs.home.network.dto.news.NewsChannelsDTO
import com.zs.home.news.fragment.NewsListFragment
import java.util.ArrayList
import java.util.HashMap

class NewsFragmentAdapter(fm: FragmentManager?) : FragmentPagerAdapter(
    fm!!
) {

    private var mChannels: MutableList<NewsChannelsDTO.ChannelList>? = null
    private val fragmentHashMap = HashMap<String, Fragment?>()
    fun setChannels(channels: MutableList<NewsChannelsDTO.ChannelList>?) {
        mChannels = channels
        notifyDataSetChanged()
    }

    override fun getItem(pos: Int): Fragment {
        val key = mChannels!![pos].channelId + ":" + mChannels!![pos].name
        if (fragmentHashMap[key] != null) {
            return fragmentHashMap[key]!!
        }
        val fragment: Fragment =
            NewsListFragment.newInstance(mChannels!![pos].channelId, mChannels!![pos].name)
        fragmentHashMap[key] = fragment
        return fragment
    }

    override fun getCount(): Int {
        return if (mChannels != null && mChannels!!.size > 0) {
            mChannels!!.size
        } else 0
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return mChannels!![position].name
    }

    override fun restoreState(parcelable: Parcelable?, classLoader: ClassLoader?) {}
}