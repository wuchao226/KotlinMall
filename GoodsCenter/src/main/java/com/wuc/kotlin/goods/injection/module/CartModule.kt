package com.wuc.kotlin.goods.injection.module

import com.wuc.kotlin.goods.service.CartService
import com.wuc.kotlin.goods.service.impl.CartServiceImpl
import dagger.Module
import dagger.Provides

/**
 * @author:     wuchao
 * @date:       2018/7/12 16:51
 * @desciption: 购物车 Module
 */
@Module
class CartModule {
    @Provides
    fun providerAddCart(cartService: CartServiceImpl): CartService {
        return cartService
    }
}