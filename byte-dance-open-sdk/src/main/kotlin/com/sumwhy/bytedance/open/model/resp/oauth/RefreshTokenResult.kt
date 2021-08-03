package com.sumwhy.bytedance.open.model.resp.oauth

import com.sumwhy.bytedance.open.model.resp.BaseData

data class RefreshTokenResult(

    /**
     * 接口调用凭证
     */
    val accessToken: String?,

    /**
     * 用户刷新凭证
     */
    val refreshToken: String?,

    /**
     * 当前应用下，授权用户唯一标识
     */
    val openId: String?,
    /**
     * refresh_token凭证超时时间，单位（秒)
     */
    val refreshExpiresIn: Int?,

    /**
     * 用户授权的作用域
     */
    val scope: String?,

    /**
     * 过期时间，单位（秒）
     */
    val expiresIn: Int?,
    val captcha: String,
    val descUrl: String,
    override val description: String,
    override val errorCode: Int,
) : BaseData(errorCode, description)

