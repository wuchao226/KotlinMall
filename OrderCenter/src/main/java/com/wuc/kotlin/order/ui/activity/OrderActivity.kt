package com.wuc.kotlin.order.ui.activity

import android.os.Bundle
import android.support.design.widget.TabLayout
import com.kotlin.order.common.OrderStatus
import com.wuc.kotlin.base.ui.activity.BaseActivity
import com.wuc.kotlin.order.R
import com.wuc.kotlin.order.common.OrderConstant
import com.wuc.kotlin.order.ui.adapter.OrderVpAdapter
import kotlinx.android.synthetic.main.activity_order.*

/**
 * @author:     wuchao
 * @date:       2018/7/19 17:58
 * @desciption: 订单Activity  主要包含不同订单状态的Fragment
 */
class OrderActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)
        initView()
    }

    /*
        初始化视图
     */
    private fun initView() {
        mOrderTab.tabMode = TabLayout.MODE_FIXED
        mOrderVp.adapter = OrderVpAdapter(supportFragmentManager)
        mOrderTab.setupWithViewPager(mOrderVp)

        //根据订单状态设置当前页面
        mOrderVp.currentItem = intent.getIntExtra(OrderConstant.KEY_ORDER_STATUS, OrderStatus.ORDER_ALL)
    }
}