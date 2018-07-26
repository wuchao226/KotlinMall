package com.wuc.kotlin.goods.presenter.view

import com.kotlin.goods.data.protocol.Goods
import com.wuc.kotlin.base.presenter.view.BaseView

/**
 * @author:     wuchao
 * @date:       2018/7/11 10:41
 * @desciption: 商品详情 视图回调
 */
interface GoodsDetailView : BaseView {

    //获取商品详情
    fun onGetGoodsDetailResult(result: Goods)

    //加入购物车
    fun onAddCartResult(result: Int)
}