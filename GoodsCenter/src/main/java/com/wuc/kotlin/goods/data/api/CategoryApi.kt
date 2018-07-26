package com.wuc.kotlin.goods.data.api

import com.wuc.kotlin.base.data.protocol.BaseResp
import com.wuc.kotlin.goods.data.protocol.Category
import com.wuc.kotlin.goods.data.protocol.GetCategoryReq
import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.POST

/**
 * @author:     wuchao
 * @date:       2018/7/5 11:04
 * @desciption:  商品分类接口
 */
interface CategoryApi {
    /*
       获取商品分类列表
    */
    @POST("category/getCategory")
    fun getCategory(@Body req: GetCategoryReq): Observable<BaseResp<MutableList<Category>?>>
}