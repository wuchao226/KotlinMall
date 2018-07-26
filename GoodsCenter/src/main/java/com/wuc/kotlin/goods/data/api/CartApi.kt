package com.wuc.kotlin.goods.data.api

import com.wuc.kotlin.base.data.protocol.BaseResp
import com.wuc.kotlin.goods.data.protocol.AddCartReq
import com.wuc.kotlin.goods.data.protocol.CartGoods
import com.wuc.kotlin.goods.data.protocol.DeleteCartReq
import com.wuc.kotlin.goods.data.protocol.SubmitCartReq
import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.POST

/*
    购物车 接口
 */
interface CartApi {
    /*
        获取购物车列表
     */
    @POST("cart/getList")
    fun getCartList(): Observable<BaseResp<MutableList<CartGoods>?>>

    /*
        添加商品到购物车
     */
    @POST("cart/add")
    fun addCart(@Body req: AddCartReq): Observable<BaseResp<Int>>

    /*
        删除购物车商品
     */
    @POST("cart/delete")
    fun deleteCartList(@Body req: DeleteCartReq): Observable<BaseResp<String>>

    /*
        提交购物车商品
     */
    @POST("cart/submit")
    fun submitCart(@Body req: SubmitCartReq): Observable<BaseResp<Int>>
}
