package com.wuc.kotlin.user.service.impl

import com.wuc.kotlin.base.ext.convert
import com.wuc.kotlin.user.data.respository.UploadRepository
import com.wuc.kotlin.user.service.UploadService
import io.reactivex.Observable
import javax.inject.Inject

/**
 * @author:     wuchao
 * @date:       2018/7/2 16:15
 * @desciption: 上传业务实现类
 */
class UploadServiceImpl @Inject constructor() : UploadService {
    @Inject
    lateinit var reponsitory: UploadRepository

    override fun getUploadToken(): Observable<String> {
        return reponsitory.getUploadToken().convert()
    }
}