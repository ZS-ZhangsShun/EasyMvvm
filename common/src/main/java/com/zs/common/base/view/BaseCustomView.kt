package com.zs.common.base.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.zs.common.base.viewmodel.BaseViewModel

abstract class BaseCustomView<BINDING : ViewDataBinding, VIEWMODEL : BaseViewModel> : LinearLayout,
    IBaseCustomView<VIEWMODEL> {
    protected lateinit var binding: BINDING
    protected lateinit var viewModel: VIEWMODEL

    constructor(context: Context) : super(context) {
        init()
    }

    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet) {
        init()
    }

    constructor(context: Context, attributeSet: AttributeSet, defStyleAttr: Int) : super(
        context,
        attributeSet,
        defStyleAttr
    ) {
        init()
    }

    constructor(
        context: Context,
        attributeSet: AttributeSet,
        defStyleAttr: Int,
        defStyleRes: Int
    ) : super(
        context,
        attributeSet,
        defStyleAttr,
        defStyleRes
    ) {
        init()
    }

    private fun init() {
        binding = DataBindingUtil.inflate(LayoutInflater.from(context), getLayoutId(), this, false)
        binding.root.setOnClickListener {
            onRootViewClicked()
        }
        addView(binding.root)
    }

    override fun setData(viewModel: VIEWMODEL) {
        bindViewModel(viewModel)
        binding.executePendingBindings()
        this.viewModel = viewModel
    }

    /**
     * 子类去实现按照自己的模型去和viewmodel关联
     */
    abstract fun bindViewModel(viewModel: VIEWMODEL)

    /**
     * 子类去实现自己的点击逻辑
     */
    abstract fun onRootViewClicked()

    /**
     * 子类实现并传入布局id
     */
    abstract fun getLayoutId(): Int
}