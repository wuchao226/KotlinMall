package com.wuc.kotlin.message.service

import com.wuc.kotlin.message.data.protocol.Message
import io.reactivex.Observable

/*
   消息业务接口
 */
interface MessageService {
    //获取消息列表
    fun getMessageList(): Observable<MutableList<Message>?>
}
