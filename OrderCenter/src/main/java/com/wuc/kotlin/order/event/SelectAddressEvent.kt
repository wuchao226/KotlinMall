package com.wuc.kotlin.order.event

import com.wuc.kotlin.order.data.protocol.ShipAddress

/**
 * @author:     wuchao
 * @date:       2018/7/20 13:30
 * @desciption: 选择收货人信息事件
 */
class SelectAddressEvent(val address: ShipAddress)