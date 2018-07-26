package com.wuc.kotlin.goods.injection.module

import com.wuc.kotlin.goods.service.CategoryService
import com.wuc.kotlin.goods.service.impl.CategoryServiceImpl
import dagger.Module
import dagger.Provides

/**
 * @author:     wuchao
 * @date:       2018/7/5 11:23
 * @desciption: 商品分类Module
 */
@Module
class CategoryModule {

    @Provides
    fun providerCategoryService(categoryService: CategoryServiceImpl): CategoryService {
        return categoryService
    }
}