package com.wuc.kotlin.goods.presenter

import com.kotlin.goods.data.protocol.Goods
import com.wuc.kotlin.base.ext.execute
import com.wuc.kotlin.base.presenter.BasePresenter
import com.wuc.kotlin.base.rx.BaseObserver
import com.wuc.kotlin.base.utils.AppPrefsUtils
import com.wuc.kotlin.goods.common.GoodsConstant
import com.wuc.kotlin.goods.presenter.view.GoodsDetailView
import com.wuc.kotlin.goods.service.CartService
import com.wuc.kotlin.goods.service.GoodsService
import javax.inject.Inject

/**
 * @author:     wuchao
 * @date:       2018/7/11 10:45
 * @desciption: 商品详情 Presenter
 */
class GoodsDetailPresenter @Inject constructor() : BasePresenter<GoodsDetailView>() {

    @Inject
    lateinit var goodsService: GoodsService
    @Inject
    lateinit var cartService: CartService

    /*
        获取商品详情
     */
    fun getGoodsDetailList(goodsId: Int) {
        if (!checkNetWork()) {
            return
        }
        mView.showLoading()
        goodsService.getGoodsDetail(goodsId)
                .execute(object : BaseObserver<Goods>(mView) {
                    override fun onNext(t: Goods) {
                        super.onNext(t)
                        mView.onGetGoodsDetailResult(t)
                    }
                }, lifecycleProvider)
    }

    /*
        加入购物车
     */
    fun addCart(goodsId: Int, goodsDesc: String, goodsIcon: String, goodsPrice: Long,
                goodsCount: Int, goodsSku: String) {
        if (!checkNetWork()) {
            return
        }
        mView.showLoading()
        cartService.addCart(goodsId, goodsDesc, goodsIcon, goodsPrice, goodsCount, goodsSku)
                .execute(object : BaseObserver<Int>(mView) {
                    override fun onNext(t: Int) {
                        super.onNext(t)
                        AppPrefsUtils.putInt(GoodsConstant.SP_CART_SIZE, t)
                        mView.onAddCartResult(t)
                    }
                }, lifecycleProvider)
    }
}