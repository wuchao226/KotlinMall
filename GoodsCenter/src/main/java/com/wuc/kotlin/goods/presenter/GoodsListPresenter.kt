package com.wuc.kotlin.goods.presenter

import com.kotlin.goods.data.protocol.Goods
import com.wuc.kotlin.base.ext.execute
import com.wuc.kotlin.base.presenter.BasePresenter
import com.wuc.kotlin.base.rx.BaseObserver
import com.wuc.kotlin.goods.presenter.view.GoodsListView
import com.wuc.kotlin.goods.service.GoodsService
import javax.inject.Inject

/**
 * @author:     wuchao
 * @date:       2018/7/6 17:17
 * @desciption: 商品列表 Presenter
 */
class GoodsListPresenter @Inject constructor() : BasePresenter<GoodsListView>() {

    @Inject
    lateinit var goodsService: GoodsService

    /*
    获取商品列表
     */
    fun getGoodsList(categoryId: Int, pageNo: Int) {
        if (!checkNetWork()) {
            return
        }
        mView.showLoading()
        goodsService.getGoodsList(categoryId, pageNo)
                .execute(object : BaseObserver<MutableList<Goods>?>(mView) {
                    override fun onNext(t: MutableList<Goods>?) {
                        super.onNext(t)
                        mView.onGetGoodsListResult(t)
                    }
                }, lifecycleProvider)
    }

    /*
    根据关键字 搜索商品
     */
    fun getGoodsListByKeyword(keyword: String, pageNo: Int) {
        if (!checkNetWork()) {
            return
        }
        mView.showLoading()
        goodsService.getGoodsListByKeyword(keyword, pageNo)
                .execute(object : BaseObserver<MutableList<Goods>?>(mView) {
                    override fun onNext(t: MutableList<Goods>?) {
                        super.onNext(t)
                        mView.onGetGoodsListResult(t)
                    }
                }, lifecycleProvider)
    }
}