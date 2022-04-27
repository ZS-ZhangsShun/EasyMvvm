package com.zs.home.news.adapter

import com.zs.home.news.fragment.NewsListFragment.Companion.newInstance
import androidx.fragment.app.FragmentPagerAdapter
import com.zs.home.news.fragment.NewsListFragment
import android.os.Parcelable
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import java.util.ArrayList
import java.util.HashMap

class NewsFragmentAdapter(fm: FragmentManager?) : FragmentPagerAdapter(
    fm!!
) {
    class Channel {
        var channelId: String? = null
        var channelName: String? = null
    }

    private var mChannels: ArrayList<Channel>? = null
    private val fragmentHashMap = HashMap<String, Fragment?>()
    fun setChannels(channels: ArrayList<Channel>?) {
        mChannels = channels
        notifyDataSetChanged()
    }

    override fun getItem(pos: Int): Fragment {
        val key = mChannels!![pos].channelId + ":" + mChannels!![pos].channelName
        if (fragmentHashMap[key] != null) {
            return fragmentHashMap[key]!!
        }
        val fragment: Fragment =
            newInstance(mChannels!![pos].channelId, mChannels!![pos].channelName)
        fragmentHashMap[key] = fragment
        return fragment
    }

    override fun getCount(): Int {
        return if (mChannels != null && mChannels!!.size > 0) {
            mChannels!!.size
        } else 0
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return mChannels!![position].channelName
    }

    override fun restoreState(parcelable: Parcelable?, classLoader: ClassLoader?) {}
}