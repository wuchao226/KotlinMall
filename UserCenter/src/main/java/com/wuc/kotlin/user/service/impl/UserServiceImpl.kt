package com.wuc.kotlin.user.service.impl

import com.wuc.kotlin.base.ext.convert
import com.wuc.kotlin.base.ext.convertBoolean
import com.wuc.kotlin.user.data.protocol.UserInfo
import com.wuc.kotlin.user.data.respository.UserRepository
import com.wuc.kotlin.user.service.UserService
import io.reactivex.Observable
import javax.inject.Inject

/**
 * @author:     wuchao
 * @date:       2018/6/21 16:25
 * @desciption: 用户模块业务实现类
 */
class UserServiceImpl @Inject constructor() : UserService {

    @Inject
    lateinit var repository: UserRepository

    /**
     * 注册
     */
    override fun register(mobile: String, pwd: String, verityCode: String): Observable<Boolean> {
        return repository.register(mobile, pwd, verityCode)
                .convertBoolean()
    }

    /**
     * 登录
     */
    override fun login(mobile: String, pwd: String, pushId: String): Observable<UserInfo> {
        return repository.login(mobile, pwd, pushId).convert()
    }

    /**
     * 忘记密码
     */
    override fun forgetPwd(mobile: String, verifyCode: String): Observable<Boolean> {
        return repository.forgetPwd(mobile, verifyCode).convertBoolean()
    }

    /**
     *  重置密码
     */
    override fun resetPwd(mobile: String, pwd: String): Observable<Boolean> {
        return repository.resetPwd(mobile, pwd).convertBoolean()
    }

    /**
     *  修改用户资料
     */
    override fun editUser(userIcon: String, userName: String, userGender: String, userSign: String):
            Observable<UserInfo> {
        return repository.editUser(userIcon,userName,userGender,userSign).convert()
    }

}