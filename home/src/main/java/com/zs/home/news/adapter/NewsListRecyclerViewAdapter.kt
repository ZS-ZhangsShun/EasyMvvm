package com.zs.home.news.adapter

import androidx.recyclerview.widget.RecyclerView
import android.view.ViewGroup
import com.zs.common.base.viewholder.BaseViewHolderJava
import com.zs.common.base.viewmodel.BaseViewModel
import com.zs.home.news.view.title.TitleView
import com.zs.home.news.view.titlewithpicture.TitlePictureView
import com.zs.home.news.view.titlewithpicture.TitlePictureViewModel

/**
 * 单一职责 只关心数据到view的绑定 不处理 view和数据的细节
 */
class NewsListRecyclerViewAdapter :
    RecyclerView.Adapter<BaseViewHolderJava>() {
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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolderJava {
        if (viewType == VIEW_TYPE_PICTURE_TITLE) {
            return BaseViewHolderJava(
                TitlePictureView(parent.context)
            )
        } else {
            return BaseViewHolderJava(
                TitleView(
                    parent.context
                )
            )
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolderJava, position: Int) {
        holder.bindData(mItems!![position])
    }
}