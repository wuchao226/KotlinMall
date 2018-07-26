package com.wuc.kotlin.message.service.impl


import com.wuc.kotlin.base.ext.convert
import com.wuc.kotlin.message.data.protocol.Message
import com.wuc.kotlin.message.data.repository.MessageRepository
import com.wuc.kotlin.message.service.MessageService
import io.reactivex.Observable
import javax.inject.Inject

/*
   消息业务层
 */
class MessageServiceImpl @Inject constructor() : MessageService {

    @Inject
    lateinit var repository: MessageRepository

    /*
        获取消息列表
     */
    override fun getMessageList(): Observable<MutableList<Message>?> {
        return repository.getMessageList().convert()
    }

}
