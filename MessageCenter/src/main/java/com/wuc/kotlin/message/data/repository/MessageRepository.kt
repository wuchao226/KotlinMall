package com.wuc.kotlin.message.data.repository


import com.wuc.kotlin.base.data.net.RetrofitFactory
import com.wuc.kotlin.base.data.protocol.BaseResp
import com.wuc.kotlin.message.data.api.MessageApi
import com.wuc.kotlin.message.data.protocol.Message
import io.reactivex.Observable
import javax.inject.Inject


/*
   消息数据层
 */
class MessageRepository @Inject constructor() {

    /*
        获取消息列表
     */
    fun getMessageList(): Observable<BaseResp<MutableList<Message>?>> {
        return RetrofitFactory.instance.create(MessageApi::class.java).getMessageList()
    }

}
