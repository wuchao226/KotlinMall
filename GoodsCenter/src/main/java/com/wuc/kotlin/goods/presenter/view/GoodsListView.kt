package com.wuc.kotlin.goods.presenter.view

import com.kotlin.goods.data.protocol.Goods
import com.wuc.kotlin.base.presenter.view.BaseView

/**
 * @author:     wuchao
 * @date:       2018/7/6 17:18
 * @desciption: 商品列表 视图回调
 */
interface GoodsListView : BaseView {
    //获取商品列表
    fun onGetGoodsListResult(result: MutableList<Goods>?)
}