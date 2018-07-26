package com.wuc.kotlin.base.widgets

import android.annotation.SuppressLint
import android.content.Context
import android.os.Handler
import android.util.AttributeSet
import android.widget.Button
import com.wuc.kotlin.base.R

/**
 * @author:     wuchao
 * @date:       2018/6/27 17:36
 * @desciption: 获取验证码按钮，带倒计时
 */
class VerifyButton @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : Button(context, attrs, defStyleAttr) {

    private val mHandler: Handler
    private var mCount = 60
    private var mOnVerifyBtnClick: OnVerifyBtnClick? = null

    init {
        this.text = "获取验证码"
        mHandler = Handler()
    }

    /**
     * 倒计时，并处理点击事件
     */
    fun requestSendVerifyNumber() {
        mHandler.postDelayed(countDown, 0)
        if (mOnVerifyBtnClick != null) {
            mOnVerifyBtnClick!!.onClick()
        }
    }

    /**
     *  倒计时
     */
    @SuppressLint("SetTextI18n")
    private val countDown = object : Runnable {
        override fun run() {
            this@VerifyButton.text = mCount.toString() + "s "
            this@VerifyButton.setBackgroundColor(resources.getColor(R.color.common_disable))
            this@VerifyButton.setTextColor(resources.getColor(R.color.common_white))
            this@VerifyButton.isEnabled = false
            if (mCount > 0) {
                mHandler.postDelayed(this, 1000)
            } else {
                resetCounter()
            }
            mCount--
        }

    }

    fun removeRunable() {
        mHandler.removeCallbacks(countDown)
    }

    /**
     * 恢复到初始状态
     */
    private fun resetCounter(vararg txt: String) {
        this.isEnabled = true
        if (txt.isNotEmpty() && "" != txt[0]) {
            this.text = txt[0]
        } else {
            this.text = "重获验证码"
        }
        this.setBackgroundColor(resources.getColor(R.color.transparent))
        this.setTextColor(resources.getColor(R.color.common_blue))
        mCount = 60
    }

    /**
     * 点击事件接口
     */
    interface OnVerifyBtnClick {
        fun onClick()
    }

    fun setOnVerifyBtnClick(onVerifyBtnClick: OnVerifyBtnClick) {
        this.mOnVerifyBtnClick = onVerifyBtnClick
    }
}