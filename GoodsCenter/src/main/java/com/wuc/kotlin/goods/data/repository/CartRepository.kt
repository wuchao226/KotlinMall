package com.wuc.kotlin.goods.data.repository

import com.wuc.kotlin.base.data.net.RetrofitFactory
import com.wuc.kotlin.base.data.protocol.BaseResp
import com.wuc.kotlin.goods.data.api.CartApi
import com.wuc.kotlin.goods.data.protocol.AddCartReq
import com.wuc.kotlin.goods.data.protocol.CartGoods
import com.wuc.kotlin.goods.data.protocol.DeleteCartReq
import com.wuc.kotlin.goods.data.protocol.SubmitCartReq
import io.reactivex.Observable
import javax.inject.Inject

/**
 * @author:     wuchao
 * @date:       2018/7/12 15:08
 * @desciption: 购物车 数据层
 */
class CartRepository @Inject constructor() {
    /*
       获取购物车列表
     */
    fun getCartList(): Observable<BaseResp<MutableList<CartGoods>?>> {
        return RetrofitFactory.instance.create(CartApi::class.java)
                .getCartList()
    }

    /*
        添加商品到购物车
     */
    fun addCart(goodsId: Int, goodsDesc: String, goodsIcon: String, goodsPrice: Long,
                goodsCount: Int, goodsSku: String): Observable<BaseResp<Int>> {
        return RetrofitFactory.instance.create(CartApi::class.java)
                .addCart(AddCartReq(goodsId, goodsDesc, goodsIcon, goodsPrice, goodsCount, goodsSku))
    }

    /*
        删除购物车商品
     */
    fun deleteCartList(list: List<Int>): Observable<BaseResp<String>> {
        return RetrofitFactory.instance.create(CartApi::class.java)
                .deleteCartList(DeleteCartReq(list))
    }

    /*
        提交购物车商品
     */
    fun submitCart(list: List<CartGoods>, totalPrice: Long): Observable<BaseResp<Int>> {
        return RetrofitFactory.instance.create(CartApi::class.java)
                .submitCart(SubmitCartReq(list, totalPrice))
    }
}