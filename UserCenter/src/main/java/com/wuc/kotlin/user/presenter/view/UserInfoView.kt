package com.wuc.kotlin.user.presenter.view

import com.wuc.kotlin.base.presenter.view.BaseView
import com.wuc.kotlin.user.data.protocol.UserInfo

/**
 * @author:     wuchao
 * @date:       2018/6/30 22:26
 * @desciption: 编辑用户资料 视图回调
 */
interface UserInfoView : BaseView {
    /*
     * 获取上传凭证回调
     */
    fun onGetUploadTokenResult(result: String)

    /*
     * 编辑用户资料回调
     */
    fun onEditUserResult(result: UserInfo)
}