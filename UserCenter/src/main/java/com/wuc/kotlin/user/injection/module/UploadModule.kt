package com.wuc.kotlin.user.injection.module

import com.wuc.kotlin.user.service.UploadService
import com.wuc.kotlin.user.service.impl.UploadServiceImpl
import dagger.Module
import dagger.Provides

/**
 * @author:     wuchao
 * @date:       2018/7/2 16:13
 * @desciption: 上传Module
 */
@Module
class UploadModule {

    @Provides
    fun providerUploadService(uploadService: UploadServiceImpl): UploadService {
        return uploadService
    }
}