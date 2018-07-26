package com.wuc.kotlin.goods

import android.widget.EditText
import org.jetbrains.anko.find
import ren.qinc.numberbutton.NumberButton
import ren.qinc.numberbutton.R

/**
 * @author:     wuchao
 * @date:       2018/7/11 16:42
 * @desciption:
 */
/*
三方控件扩展
 */
fun NumberButton.getEditText(): EditText {
    return find(R.id.text_count)
}