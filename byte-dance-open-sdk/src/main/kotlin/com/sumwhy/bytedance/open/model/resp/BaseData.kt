package com.sumwhy.bytedance.open.model.resp

import com.sumwhy.bytedance.open.common.enumeration.ErrorCode

/**
 * <p> @date: 2021-07-28 16:00</p>
 * @author 何嘉豪
 */
open class BaseData(

    /**
     * 错误码
     */
    open val errorCode: Int,

    /**
     * 错误详情
     */
    open val description: String,
) {
    fun isSuccessful() = ErrorCode.SUCCESS.errorCode == errorCode
}