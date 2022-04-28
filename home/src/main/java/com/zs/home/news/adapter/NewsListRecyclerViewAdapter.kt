package com.zs.home.news.adapter

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.zs.home.network.dto.news.NewsListDTO.Contentlist
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import com.zs.home.R
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.zs.common.base.viewholder.BaseViewHolder
import com.zs.home.news.base.BaseViewModel
import com.zs.home.news.view.title.TitleView
import com.zs.home.news.view.title.TitleViewModel
import com.zs.home.news.view.titlewithpicture.TitlePictureView
import com.zs.home.news.view.titlewithpicture.TitlePictureViewModel

class NewsListRecyclerViewAdapter(private val mContext: Context) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val VIEW_TYPE_PICTURE_TITLE = 1
    private val VIEW_TYPE_TITLE = 2
    private var mItems: MutableList<BaseViewModel>? = null
    fun setData(items: MutableList<BaseViewModel>) {
        mItems = items
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return if (mItems != null) {
            mItems!!.size
        } else 0
    }

    override fun getItemViewType(position: Int): Int {
        return if (mItems != null && mItems!![position] is TitlePictureViewModel) {
            VIEW_TYPE_PICTURE_TITLE
        } else VIEW_TYPE_TITLE
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == VIEW_TYPE_PICTURE_TITLE) {
            return BaseViewHolder(TitlePictureView(mContext))
        } else {
            return BaseViewHolder(TitleView(mContext))
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder.itemView is TitlePictureView) {
            (holder.itemView as TitlePictureView).setData(mItems!![position] as TitlePictureViewModel)
        } else if (holder.itemView is TitleView) {
            (holder.itemView as TitleView).setData(mItems!![position] as TitleViewModel)
        }
    }
}