package com.sumwhy.bytedance.open.common.enumeration

/**
 * <p> @date: 2021-07-28 16:31</p>
 * @author 何嘉豪
 */
enum class ErrorCode(val errorCode: Int) {

    /**
     * 请求成功
     */
    SUCCESS(0),

    /**
     * refreshToken 无效/过期
     */
    INVALID_REFRESH_TOKEN(10010),

    /**
     * 请求参数accessToken openId不匹配
     */
    OPEN_ID_ACCESS_TOKEN_NOT_MATCH(2190015),

}