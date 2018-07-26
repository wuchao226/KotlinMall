package com.wuc.kotlin.goods.service.impl

import com.kotlin.goods.data.protocol.Goods
import com.wuc.kotlin.base.ext.convert
import com.wuc.kotlin.goods.data.repository.GoodsRepository
import com.wuc.kotlin.goods.service.GoodsService
import io.reactivex.Observable
import javax.inject.Inject

/**
 * @author:     wuchao
 * @date:       2018/7/6 17:38
 * @desciption: 商品 业务层 实现类
 */
class GoodsServiceImpl @Inject constructor() : GoodsService {

    @Inject
    lateinit var repository: GoodsRepository

    /*
    获取商品列表
     */
    override fun getGoodsList(categoryId: Int, pageNo: Int): Observable<MutableList<Goods>?> {
        return repository.getGoodsList(categoryId, pageNo).convert()
    }

    /*
     根据关键字查询商品
     */
    override fun getGoodsListByKeyword(keyword: String, pageNo: Int): Observable<MutableList<Goods>?> {
        return repository.getGoodsListByKeyword(keyword, pageNo).convert()
    }

    /*
     获取商品详情
     */
    override fun getGoodsDetail(goodsId: Int): Observable<Goods> {
        return repository.getGoodsDetail(goodsId).convert()
    }
}