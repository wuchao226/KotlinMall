package com.wuc.kotlin.base.widgets

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import com.wuc.kotlin.base.R
import com.wuc.kotlin.base.R.id.mContentTv
import com.wuc.kotlin.base.R.id.mLabelTv
import kotlinx.android.synthetic.main.layout_label_textview.view.*

/**
 * @author:     wuchao
 * @date:       2018/7/20 14:33
 * @desciption: LabelTextView封装
 */
class LabelTextView @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    private var mLabelText: CharSequence? = null
    private var mContentText: CharSequence? = null

    init {
        val typesArray = context.obtainStyledAttributes(attrs, R.styleable.LabelTextView)
        mLabelText = typesArray.getText(R.styleable.LabelTextView_labelText)
        mContentText = typesArray.getText(R.styleable.LabelTextView_contentText)
        initView()
        typesArray.recycle()
    }

    /*
        初始化视图
     */
    private fun initView() {
        View.inflate(context, R.layout.layout_label_textview, this)
        mLabelText?.let {
            mLabelTv.text = it
        }
        mContentText?.let {
            mContentTv.text = it
        }
    }

    /*
        设置内容文本
     */
    fun setContentText(text: String) {
        mContentTv.text = text
    }
}