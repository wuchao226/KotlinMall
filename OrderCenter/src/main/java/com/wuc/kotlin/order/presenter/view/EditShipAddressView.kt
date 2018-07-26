package com.wuc.kotlin.order.presenter.view

import com.wuc.kotlin.base.presenter.view.BaseView

/**
 * @author:     wuchao
 * @date:       2018/7/19 11:08
 * @desciption: 编辑收货人信息  视图回调
 */
interface EditShipAddressView : BaseView {

    //添加收货人回调
    fun onAddShipAddressResult(result: Boolean)

    //修改收货人回调
    fun onEditShipAddressResult(result: Boolean)
}