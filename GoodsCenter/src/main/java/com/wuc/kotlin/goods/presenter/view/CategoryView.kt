package com.wuc.kotlin.goods.presenter.view

import com.wuc.kotlin.base.presenter.view.BaseView
import com.wuc.kotlin.goods.data.protocol.Category

/**
 * @author:     wuchao
 * @date:       2018/7/5 13:29
 * @desciption: 商品分类 视图回调
 */
interface CategoryView : BaseView {
    //获取商品分类列表
    fun onGetCategoryResult(result: MutableList<Category>?)
}