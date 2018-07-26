package com.wuc.kotlin.goods.data.protocol

/*
    按分类搜索商品
 */
data class GetGoodsListReq(val categoryId: Int,val pageNo: Int)
