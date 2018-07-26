package com.wuc.kotlin.goods.injection.module

import com.wuc.kotlin.goods.service.GoodsService
import com.wuc.kotlin.goods.service.impl.GoodsServiceImpl
import dagger.Module
import dagger.Provides

/**
 * @author:     wuchao
 * @date:       2018/7/9 14:13
 * @desciption: 商品Module
 */
@Module
class GoodsModule {

    @Provides
    fun providerGoodService(goodsService: GoodsServiceImpl): GoodsService {
        return goodsService
    }
}