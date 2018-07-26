package com.wuc.kotlin.goods.ui.activity

import android.os.Bundle
import com.wuc.kotlin.base.ui.activity.BaseActivity
import com.wuc.kotlin.goods.R
import com.wuc.kotlin.goods.ui.fragment.CartFragment

/**
 * @author:     wuchao
 * @date:       2018/7/17 11:10
 * @desciption: 购物车Activity，只是fragment一个壳
 */
class CartActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)
        val fragment = supportFragmentManager.findFragmentById(R.id.fragment_cart)
        (fragment as CartFragment).setBackVisible(true)
    }
}