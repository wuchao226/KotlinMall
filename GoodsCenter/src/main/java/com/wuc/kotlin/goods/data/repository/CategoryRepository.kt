package com.wuc.kotlin.goods.data.repository

import com.wuc.kotlin.base.data.net.RetrofitFactory
import com.wuc.kotlin.base.data.protocol.BaseResp
import com.wuc.kotlin.goods.data.api.CategoryApi
import com.wuc.kotlin.goods.data.protocol.Category
import com.wuc.kotlin.goods.data.protocol.GetCategoryReq
import io.reactivex.Observable
import javax.inject.Inject

/**
 * @author:     wuchao
 * @date:       2018/7/5 11:07
 * @desciption: 商品分类 数据层
 */
class CategoryRepository @Inject constructor() {

    /*
       获取商品分类
    */
    fun getCategory(parentId: Int): Observable<BaseResp<MutableList<Category>?>> {
        return RetrofitFactory.instance.create(CategoryApi::class.java)
                .getCategory(GetCategoryReq(parentId))
    }
}