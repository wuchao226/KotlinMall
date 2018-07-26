package com.wuc.kotlin.goods.presenter.view

import com.wuc.kotlin.base.presenter.view.BaseView
import com.wuc.kotlin.goods.data.protocol.CartGoods

/**
 * @author:     wuchao
 * @date:       2018/7/13 15:52
 * @desciption: 购物车页面 视图回调
 */
interface CartListView : BaseView {
    /*
        获取购物车列表
     */
    fun onGetCartListResult(result: MutableList<CartGoods>?)

    /*
        删除购物车
     */
    fun onDeleteCartListResult(result: Boolean)

    /*
        提交购物车
     */
    fun onSubmitCartListResult(result: Int)
}