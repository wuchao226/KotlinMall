package com.wuc.kotlin.goods.presenter

import com.wuc.kotlin.base.ext.execute
import com.wuc.kotlin.base.presenter.BasePresenter
import com.wuc.kotlin.base.rx.BaseObserver
import com.wuc.kotlin.goods.data.protocol.Category
import com.wuc.kotlin.goods.presenter.view.CategoryView
import com.wuc.kotlin.goods.service.CategoryService
import javax.inject.Inject

/**
 * @author:     wuchao
 * @date:       2018/7/5 13:28
 * @desciption: 商品分类 Presenter
 */
class CategoryPresenter @Inject constructor() : BasePresenter<CategoryView>() {

    @Inject
    lateinit var categoryService: CategoryService

    /*
    获取商品分类列表
     */
    fun getCategory(parentId: Int) {
        if (!checkNetWork()) {
            return
        }
        mView.showLoading()
        categoryService.getCategory(parentId)
                .execute(object : BaseObserver<MutableList<Category>?>(mView) {
                    override fun onNext(t: MutableList<Category>?) {
                        super.onNext(t)
                        mView.onGetCategoryResult(t)
                    }
                }, lifecycleProvider)
    }
}