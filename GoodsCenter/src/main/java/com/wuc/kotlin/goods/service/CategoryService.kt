package com.wuc.kotlin.goods.service

import com.wuc.kotlin.goods.data.protocol.Category
import io.reactivex.Observable

/**
 * @author:     wuchao
 * @date:       2018/7/5 11:24
 * @desciption: 商品分类 业务层 接口
 */
interface CategoryService {
    /*
        获取分类
     */
    fun getCategory(parentId: Int): Observable<MutableList<Category>?>
}