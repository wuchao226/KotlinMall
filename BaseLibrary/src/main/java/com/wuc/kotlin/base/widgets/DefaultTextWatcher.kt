package com.wuc.kotlin.base.widgets

import android.text.Editable
import android.text.TextWatcher

/**
 * @author:     wuchao
 * @date:       2018/6/27 18:38
 * @desciption: 默认TextWatcher，空实现
 */
open class DefaultTextWatcher : TextWatcher {

    override fun afterTextChanged(s: Editable?) {

    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
    }
}