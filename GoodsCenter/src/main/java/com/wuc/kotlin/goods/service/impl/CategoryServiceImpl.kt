package com.wuc.kotlin.goods.service.impl

import com.wuc.kotlin.base.ext.convert
import com.wuc.kotlin.goods.data.protocol.Category
import com.wuc.kotlin.goods.data.repository.CategoryRepository
import com.wuc.kotlin.goods.service.CategoryService
import io.reactivex.Observable
import javax.inject.Inject

/**
 * @author:     wuchao
 * @date:       2018/7/5 11:25
 * @desciption: 商品分类 业务层 实现类
 */
class CategoryServiceImpl @Inject constructor() : CategoryService {

    @Inject
    lateinit var respository: CategoryRepository

    override fun getCategory(parentId: Int): Observable<MutableList<Category>?> {
        return respository.getCategory(parentId).convert()
    }
}