package com.wuc.kotlin.base.rx

import com.wuc.kotlin.base.common.ResultCode
import com.wuc.kotlin.base.data.protocol.BaseResp
import io.reactivex.Observable
import io.reactivex.functions.Function

/**
 * @author:     wuchao
 * @date:       2018/6/26 13:27
 * @desciption: Boolean 类型转换封装
 */
class BaseFuncBoolean<T> : Function<BaseResp<T>, Observable<Boolean>> {
    override fun apply(t: BaseResp<T>): Observable<Boolean> {
        return if (t.status != ResultCode.SUCCESS) {
            Observable.error(BaseException(t.status, t.message))
        } else {
            Observable.just(true)
        }
    }
}