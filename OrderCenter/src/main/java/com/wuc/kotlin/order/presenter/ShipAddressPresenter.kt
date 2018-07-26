package com.wuc.kotlin.order.presenter

import com.wuc.kotlin.base.ext.execute
import com.wuc.kotlin.base.presenter.BasePresenter
import com.wuc.kotlin.base.rx.BaseObserver
import com.wuc.kotlin.order.data.protocol.ShipAddress
import com.wuc.kotlin.order.presenter.view.ShipAddressView
import com.wuc.kotlin.order.service.ShipAddressService
import javax.inject.Inject

/**
 * @author:     wuchao
 * @date:       2018/7/18 20:56
 * @desciption: 收货人列表Presenter
 */
class ShipAddressPresenter @Inject constructor() : BasePresenter<ShipAddressView>() {

    @Inject
    lateinit var shipAddressService: ShipAddressService

    /*
        获取收货人列表
     */
    fun getShipAddressList() {
        if (!checkNetWork()) {
            return
        }
        mView.showLoading()
        shipAddressService.getShipAddressList().execute(object : BaseObserver<MutableList<ShipAddress>?>(mView) {
            override fun onNext(t: MutableList<ShipAddress>?) {
                mView.onGetShipAddressResult(t)
            }
        }, lifecycleProvider)

    }

    /*
        设置默认收货人信息
     */
    fun setDefaultShipAddress(address: ShipAddress) {
        if (!checkNetWork()) {
            return
        }
        mView.showLoading()
        shipAddressService.editShipAddress(address).execute(object : BaseObserver<Boolean>(mView) {
            override fun onNext(t: Boolean) {
                mView.onSetDefaultResult(t)
            }
        }, lifecycleProvider)

    }

    /*
        删除收货人信息
     */
    fun deleteShipAddress(id: Int) {
        if (!checkNetWork()) {
            return
        }
        mView.showLoading()
        shipAddressService.deleteShipAddress(id).execute(object : BaseObserver<Boolean>(mView) {
            override fun onNext(t: Boolean) {
                mView.onDeleteResult(t)
            }
        }, lifecycleProvider)

    }
}