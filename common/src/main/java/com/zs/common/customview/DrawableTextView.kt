package com.zs.common.customview

import android.content.Context
import android.graphics.drawable.Drawable
import android.graphics.Canvas
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import com.zs.common.R

class DrawableTextView : AppCompatTextView {
    private var drawableLeft: Drawable? = null
    private var drawableRight: Drawable? = null
    private var drawableTop: Drawable? = null
    private var leftWidth = 0
    private var rightWidth = 0
    private var topWidth = 0
    private var leftHeight = 0
    private var rightHeight = 0
    private var topHeight = 0
    private var mContext: Context

    constructor(context: Context) : super(context) {
        mContext = context
        init(context, null)
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        mContext = context
        init(context, attrs)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        mContext = context
        init(context, attrs)
    }

    private fun init(context: Context, attrs: AttributeSet?) {
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.TextDrawable)
        drawableLeft = typedArray.getDrawable(R.styleable.TextDrawable_leftDrawable)
        drawableRight = typedArray.getDrawable(R.styleable.TextDrawable_rightDrawable)
        drawableTop = typedArray.getDrawable(R.styleable.TextDrawable_topDrawable)
        if (drawableLeft != null) {
            leftWidth = typedArray.getDimensionPixelOffset(
                R.styleable.TextDrawable_leftDrawableWidth,
                dip2px(context, 20f)
            )
            leftHeight = typedArray.getDimensionPixelOffset(
                R.styleable.TextDrawable_leftDrawableHeight,
                dip2px(context, 20f)
            )
        }
        if (drawableRight != null) {
            rightWidth = typedArray.getDimensionPixelOffset(
                R.styleable.TextDrawable_rightDrawableWidth,
                dip2px(context, 20f)
            )
            rightHeight = typedArray.getDimensionPixelOffset(
                R.styleable.TextDrawable_rightDrawableHeight,
                dip2px(context, 20f)
            )
        }
        if (drawableTop != null) {
            topWidth = typedArray.getDimensionPixelOffset(
                R.styleable.TextDrawable_topDrawableWidth,
                dip2px(context, 20f)
            )
            topHeight = typedArray.getDimensionPixelOffset(
                R.styleable.TextDrawable_topDrawableHeight,
                dip2px(context, 20f)
            )
        }
    }

    fun dip2px(context: Context, dpValue: Float): Int {
        val scale = context.resources.displayMetrics.density
        return (dpValue * scale + 0.5f).toInt()
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        if (drawableLeft != null) {
            drawableLeft!!.setBounds(0, 0, leftWidth, leftHeight)
        }
        if (drawableRight != null) {
            drawableRight!!.setBounds(0, 0, rightWidth, rightHeight)
        }
        if (drawableTop != null) {
            drawableTop!!.setBounds(0, 0, topWidth, topHeight)
        }
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        setCompoundDrawables(drawableLeft, drawableTop, drawableRight, null)
    }

    /**
     * ???????????????????????????
     */
    fun setDrawableLeft(drawableLeft: Drawable?) {
        this.drawableLeft = drawableLeft
        invalidate()
    }

    /**
     * ???????????????????????????
     */
    fun setDrawableLeft(drawableLeftRes: Int) {
        drawableLeft = mContext.resources.getDrawable(drawableLeftRes, null)
        invalidate()
    }

    /**
     * ???????????????????????????
     */
    fun setDrawableRight(drawableRight: Drawable?) {
        this.drawableRight = drawableLeft
        invalidate()
    }

    /**
     * ???????????????????????????
     */
    fun setDrawableRight(drawableRightRes: Int) {
        drawableRight = mContext.resources.getDrawable(drawableRightRes, null)
        invalidate()
    }

    /**
     * ???????????????????????????
     */
    fun setDrawable(drawableTop: Drawable?) {
        this.drawableTop = drawableTop
        invalidate()
    }

    /**
     * ???????????????????????????
     */
    fun setDrawableTop(drawableTopRes: Int) {
        drawableTop = mContext.resources.getDrawable(drawableTopRes, null)
        invalidate()
    }
}