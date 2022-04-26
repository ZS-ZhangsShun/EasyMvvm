package com.zs.common.viewpager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentManager

class VpAdapter(fm: FragmentManager, fragments: List<Fragment>) : FragmentPagerAdapter(fm) {
    private var fragments: List<Fragment>? = null

    init {
        this.fragments = fragments
    }

    override fun getItem(position: Int): Fragment {
        return fragments!![position]
    }

    override fun getCount(): Int {
        return fragments!!.size
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }
}