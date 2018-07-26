package com.wuc.kotlin.goods.data.repository

import com.kotlin.goods.data.protocol.Goods
import com.wuc.kotlin.base.data.net.RetrofitFactory
import com.wuc.kotlin.base.data.protocol.BaseResp
import com.wuc.kotlin.goods.data.api.GoodsApi
import com.wuc.kotlin.goods.data.protocol.GetGoodsDetailReq
import com.wuc.kotlin.goods.data.protocol.GetGoodsListByKeywordReq
import com.wuc.kotlin.goods.data.protocol.GetGoodsListReq
import io.reactivex.Observable
import javax.inject.Inject

/**
 * @author:     wuchao
 * @date:       2018/7/6 17:40
 * @desciption: 商品数据层
 */
class GoodsRepository @Inject constructor() {

    /*
     * 根据分类搜索商品
     */
    fun getGoodsList(categoryId: Int, pageNo: Int): Observable<BaseResp<MutableList<Goods>?>> {
        return RetrofitFactory.instance.create(GoodsApi::class.java)
                .getGoodsList(GetGoodsListReq(categoryId, pageNo))
    }

    /*
        根据关键字搜索商品
     */
    fun getGoodsListByKeyword(keyword: String, pageNo: Int): Observable<BaseResp<MutableList<Goods>?>> {
        return RetrofitFactory.instance.create(GoodsApi::class.java)
                .getGoodsListByKeyword(GetGoodsListByKeywordReq(keyword, pageNo))
    }

    /*
        商品详情
     */
    fun getGoodsDetail(goodsId: Int): Observable<BaseResp<Goods>> {
        return RetrofitFactory.instance.create(GoodsApi::class.java)
                .getGoodsDetail(GetGoodsDetailReq(goodsId))
    }

}