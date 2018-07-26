package com.wuc.kotlin.goods.service

import com.wuc.kotlin.goods.data.protocol.CartGoods
import io.reactivex.Observable

/**
 * @author:     wuchao
 * @date:       2018/7/12 15:03
 * @desciption: 购物车 业务 接口
 */
interface CartService {
    /*
        添加商品购物车
     */
    fun addCart(goodsId: Int, goodsDesc: String, goodsIcon: String, goodsPrice: Long,
                goodsCount: Int, goodsSku: String): Observable<Int>

    /*
       获取购物车列表
     */
    fun getCartList(): Observable<MutableList<CartGoods>?>

    /*
        删除购物车商品
     */
    fun deleteCartList(list: List<Int>): Observable<Boolean>

    /*
        提交购物车商品
     */
    fun submitCart(list: List<CartGoods>, totalPrice: Long): Observable<Int>
}