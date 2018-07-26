package com.wuc.kotlin.goods.data.api

import com.kotlin.goods.data.protocol.Goods
import com.wuc.kotlin.base.data.protocol.BaseResp
import com.wuc.kotlin.goods.data.protocol.GetGoodsDetailReq
import com.wuc.kotlin.goods.data.protocol.GetGoodsListByKeywordReq
import com.wuc.kotlin.goods.data.protocol.GetGoodsListReq
import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.POST

/*
    商品接口
 */
interface GoodsApi {
    /*
        获取商品列表
     */
    @POST("goods/getGoodsList")
    fun getGoodsList(@Body req: GetGoodsListReq): Observable<BaseResp<MutableList<Goods>?>>

    /*
        获取商品列表
     */
    @POST("goods/getGoodsListByKeyword")
    fun getGoodsListByKeyword(@Body req: GetGoodsListByKeywordReq): Observable<BaseResp<MutableList<Goods>?>>

    /*
        获取商品详情
     */
    @POST("goods/getGoodsDetail")
    fun getGoodsDetail(@Body req: GetGoodsDetailReq): Observable<BaseResp<Goods>>
}
