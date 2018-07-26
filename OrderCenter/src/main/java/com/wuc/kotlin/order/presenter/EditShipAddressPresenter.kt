package com.wuc.kotlin.order.presenter

import com.wuc.kotlin.base.ext.execute
import com.wuc.kotlin.base.presenter.BasePresenter
import com.wuc.kotlin.base.rx.BaseObserver
import com.wuc.kotlin.order.data.protocol.ShipAddress
import com.wuc.kotlin.order.presenter.view.EditShipAddressView
import com.wuc.kotlin.order.service.ShipAddressService
import javax.inject.Inject

/**
 * @author:     wuchao
 * @date:       2018/7/19 11:14
 * @desciption: 编辑收货人信息Presenter
 */
class EditShipAddressPresenter @Inject constructor() : BasePresenter<EditShipAddressView>() {

    @Inject
    lateinit var shipAddressService: ShipAddressService

    /*
        添加收货人信息
     */
    fun addShipAddress(shipUserName: String, shipUserMobile: String, shipAddress: String) {
        if (!checkNetWork()) {
            return
        }
        mView.showLoading()
        shipAddressService.addShipAddress(shipUserName, shipUserMobile, shipAddress)
                .execute(object : BaseObserver<Boolean>(mView) {
                    override fun onNext(t: Boolean) {
                        mView.onAddShipAddressResult(t)
                    }
                }, lifecycleProvider)

    }

    /*
        修改收货人信息
     */
    fun editShipAddress(address: ShipAddress) {
        if (!checkNetWork()) {
            return
        }
        mView.showLoading()
        shipAddressService.editShipAddress(address)
                .execute(object : BaseObserver<Boolean>(mView) {
                    override fun onNext(t: Boolean) {
                        mView.onEditShipAddressResult(t)
                    }
                }, lifecycleProvider)

    }
}