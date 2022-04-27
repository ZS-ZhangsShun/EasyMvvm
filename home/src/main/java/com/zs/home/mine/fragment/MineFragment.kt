package com.zs.home.mine.fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.zs.home.R
import com.zs.home.databinding.FragmentMineBinding

class MineFragment : Fragment() {
    private var binding: FragmentMineBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_mine, container, false)
        return binding!!.root
    }
}