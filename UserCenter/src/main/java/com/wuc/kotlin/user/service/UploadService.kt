package com.wuc.kotlin.user.service

import io.reactivex.Observable

/**
 * @author:     wuchao
 * @date:       2018/7/2 16:14
 * @desciption: 上传业务接口
 */
interface UploadService {
    fun getUploadToken(): Observable<String>
}