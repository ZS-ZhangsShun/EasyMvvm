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
import com.zs.home.news.view.title.TitleView
import com.zs.home.news.view.title.TitleViewModel

class NewsListRecyclerViewAdapter(private val mContext: Context) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val VIEW_TYPE_PICTURE_TITLE = 1
    private val VIEW_TYPE_TITLE = 2
    private var mItems: MutableList<Contentlist>? = null
    fun setData(items: MutableList<Contentlist>?) {
        mItems = items
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return if (mItems != null) {
            mItems!!.size
        } else 0
    }

    override fun getItemViewType(position: Int): Int {
        return if (mItems != null && mItems!![position].imageurls != null && mItems!![position].imageurls.size > 1) {
            VIEW_TYPE_PICTURE_TITLE
        } else VIEW_TYPE_TITLE
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view: View
        if (viewType == VIEW_TYPE_PICTURE_TITLE) {
            view = LayoutInflater.from(mContext).inflate(R.layout.picture_title_view, parent, false)
            return PictureTitleViewHolder(view)
        } else {
            return BaseViewHolder(TitleView(mContext))
        }
    }

    private inner class PictureTitleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var titleTextView: TextView
        var picutureImageView: AppCompatImageView

        init {
            titleTextView = itemView.findViewById(R.id.item_title)
            picutureImageView = itemView.findViewById(R.id.item_image)
            itemView.setOnClickListener {
                //                    WebviewActivity.startCommonWeb(mContext, "News", v.getTag()+"");
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder.itemView.tag = mItems!![position].link
        if (holder is PictureTitleViewHolder) {
            holder.titleTextView.text = mItems!![position].title
            Glide.with(holder.itemView.context)
                .load(mItems!![position].imageurls[0].url)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(holder.picutureImageView)
        } else if (holder.itemView is TitleView) {
            val titleViewModel = TitleViewModel()
            titleViewModel.jumpUrl = mItems!![position].link
            titleViewModel.name = mItems!![position].title
            (holder.itemView as TitleView).setData(titleViewModel)
        }
    }
}